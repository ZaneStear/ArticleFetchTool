package com.stear.impl;

import com.google.gson.Gson;
import com.stear.bean.BaiduPostBarJson;
import com.stear.parent.BaseFetcherWithJsoup;
import com.stear.util.StringMatcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BaiDuPostBarFetcher extends BaseFetcherWithJsoup {
    private final boolean seeAuthorOnly;

    BaiDuPostBarFetcher(boolean seeAuthorOnly) {
        this.seeAuthorOnly = seeAuthorOnly;
    }

    private static boolean $default$seeAuthorOnly() {
        return true;
    }

    public static BaiDuPostBarFetcherBuilder builder() {
        return new BaiDuPostBarFetcherBuilder();
    }

    @Override
    protected String setArticleTitle() {
        Element e=getArticleDocument().getElementsByClass("core_title_txt pull-left text-overflow  ").first();
        return e.attr("title");

    }

    @Override
    protected String setArticleContent(String articleId) {
        //总Pn数,并非贴吧所显示的页数，需要getPageNum抓取
        int pageNum = 1;
        try {
            pageNum = getPagePn(articleId);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //存储文本
        StringBuilder content = new StringBuilder();
        //遍历每一页（pn）
        //当前pn数
        int pn = 1;
        for (int i = 0; i < pageNum; i++) {
            //每一页链接
            String url = "https://tieba.baidu.com/p/" + articleId + "?see_lz=1&pn=" + pn;
            content.append(getOnePn(url));
            pn++;
        }
        return content.toString();
    }

    @Override
    public String parseUrlToId(String articleUrl) {
        return StringMatcher.matchString(articleUrl, "\\d{2,}");
    }

    @Override
    public String parseIdToUrl(String articleId) {
        if (seeAuthorOnly) {
            return "https://tieba.baidu.com/p/" + articleId + "?see_lz=1";
        }else {
            return "https://tieba.baidu.com/p/" + articleId;
        }
    }

    /**
     * 获取一个Pn的内容
     *
     * @param urlWithPn pn
     * @return String
     */
    private String getOnePn(String urlWithPn) {
        //Document
        Document document = null;
        try {
            document = Jsoup.connect(urlWithPn).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //拿到所有楼层
        Elements elements = document.getElementsByClass("l_post l_post_bright j_l_post clearfix  ");

        //解析每一楼
        StringBuilder stringBuffer = new StringBuilder();
        for (Element e :
                elements) {
            //获取该楼json数据
            String json = e.attr("data-field");
            BaiduPostBarJson jsonBean = new Gson().fromJson(json, BaiduPostBarJson.class);
            //解析出楼内容
            String content = jsonBean.getContent().getContent();

            String result = content.replace("<br>", "\r\n")//除去<br>
                    .replaceAll("<img.*>", "");//除去图片

            stringBuffer.append(result).append("\r\n");

        }
        return stringBuffer.toString();
    }

    /**
     * 获取帖子页数
     *
     * @param id 帖子id
     * @return 页数
     * @throws IOException ioE
     */
    private int getPagePn(String id) throws IOException {
        Document document = Jsoup.connect("https://tieba.baidu.com/p/" + id + "?see_lz=1").get();
        Element element = document.getElementsByClass("l_pager pager_theme_4 pb_list_pager").last();
        Element element1 = element.getAllElements().last();
        String lastPageUrl = element1.attr("href");
        //帖子Pn为1是获取不到的
        if (lastPageUrl.equals("")){ return 1;}
        String lastPageNum = lastPageUrl.substring(lastPageUrl.indexOf("pn=") + 3);
        return Integer.parseInt(lastPageNum);
    }

    public static class BaiDuPostBarFetcherBuilder {
        private boolean seeAuthorOnly$value;
        private boolean seeAuthorOnly$set;

        BaiDuPostBarFetcherBuilder() {
        }

        /**
         * 设置是否为只看楼主模式，默认为true
         * @param seeAuthorOnly true：只看楼主
         * @return {@link BaiDuPostBarFetcherBuilder}
         */
        public BaiDuPostBarFetcherBuilder seeAuthorOnly(boolean seeAuthorOnly) {
            this.seeAuthorOnly$value = seeAuthorOnly;
            this.seeAuthorOnly$set = true;
            return this;
        }

        public BaiDuPostBarFetcher build() {
            boolean seeAuthorOnly$value = this.seeAuthorOnly$value;
            if (!this.seeAuthorOnly$set) {
                seeAuthorOnly$value = BaiDuPostBarFetcher.$default$seeAuthorOnly();
            }
            return new BaiDuPostBarFetcher(seeAuthorOnly$value);
        }
    }
}

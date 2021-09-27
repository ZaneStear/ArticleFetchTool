package com.stear.impl;

import com.stear.bean.ChapterBean;
import com.stear.parent.BaseFetcherWithJsoup;
import com.stear.util.StringMatcher;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Stear
 */
public class BiliFetcher extends BaseFetcherWithJsoup {


    @Override
    public String parseUrlToId(String articleUrl) {
        return articleUrl.substring(articleUrl.lastIndexOf("v")+1);
    }

    @Override
    public String parseIdToUrl(String articleId) {
        return "https://www.bilibili.com/read/cv"+articleId;
    }

    @Override
    protected String setArticleTitle() {
        Element e= getArticleDocument().getElementsByAttributeValue("property","og:title").first();
        return e.attr("content");
    }

    @Override
    protected String setArticleAuthor() {
        Element e= getArticleDocument().getElementsByAttributeValue("name","author").first();
        return e.attr("content");
    }

    @Override
    protected String setArticleContent(String articleId) {
        Element articleDiv = getArticleDocument().getElementById("read-article-holder");
        Elements sentencePs = articleDiv.getElementsByTag("p");
        StringBuilder content = new StringBuilder();
        for (Element e :
                sentencePs) {
            String s = e.text();
            content.append(s).append("\r\n");
        }
        return content.toString();
    }

    /**
     * 抓取BiliBili专栏文集
     * @param columnId 专栏文集id
     * @return ChapterBean实体
     */
    @SneakyThrows
    public ChapterBean fetchColumn(String columnId) {
        String[] ids = null;
        Document document = Jsoup.connect("https://www.bilibili.com/read/readlist/rl" + columnId).get();
        String result=StringMatcher.matchString(document.toString(), "\\[.*]");
        result= result.substring(1, result.length() - 1);
        ids = result.split(",");
        return fetchChapterByUrls(ids);
    }
}




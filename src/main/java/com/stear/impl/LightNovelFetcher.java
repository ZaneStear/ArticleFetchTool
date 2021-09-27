package com.stear.impl;

import com.stear.parent.BaseFetcherWithJsoup;
import org.jsoup.nodes.Element;

/**
 * 实现了轻之国度轻小说抓取
 *
 * @author Stear
 */
public class LightNovelFetcher extends BaseFetcherWithJsoup {

    @Override
    protected String setArticleTitle() {
        Element element = getArticleDocument().getElementsByClass("article-title").first();
        return element.text();
    }

    @Override
    protected String setArticleAuthor() {
        Element element=getArticleDocument().getElementsByAttributeValue("name","author").first();
        return element.attr("content");
    }

    @Override
    protected String setArticleContent(String articleId) {
        Element element = getArticleDocument().getElementById("article-main-contents");
        return element.text();
    }

    @Override
    public String parseUrlToId(String articleUrl) {
        return articleUrl.substring(articleUrl.lastIndexOf("/")+1);
    }

    @Override
    public String parseIdToUrl(String articleId) {
        return "https://www.lightnovel.us/cn/detail/"+articleId;
    }
}

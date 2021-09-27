package com.stear.domain;

import com.stear.bean.ArticleBean;
import com.stear.bean.BookBean;
import com.stear.bean.ChapterBean;
import com.stear.parent.BaseFetcher;
import com.stear.parent.BaseFetcherWithJsoup;
import lombok.experimental.UtilityClass;

/**
 * 工具类，此类封装了一些常用抓取方法。
 * @author Stear
 */
@UtilityClass
public class FetchTool {

    /*public ArticleBean fetchEssay(BaseFetcher baseFetcher, String essayId) {
        return baseFetcher.fetchArticle(essayId);
    }

    public ChapterBean fetchChapter(BaseFetcher baseFetcher, String[] essayIds) {
        return baseFetcher.fetchChapter(essayIds);
    }

    public ChapterBean fetchChapter(BaseFetcher baseFetcher, String chapterId) {
        return baseFetcher.fetchChapter(chapterId);
    }

    public BookBean fetchBook(BaseFetcher baseFetcher, String bookId) {
        return baseFetcher.fetchBook(bookId);
    }

    public ArticleBean fetchEssayByUrl(BaseFetcherWithJsoup fetcherWithJsoup, String url) {
        return fetcherWithJsoup.fetchArticle(fetcherWithJsoup.parseUrlToId(url));
    }

    public ChapterBean fetchChapterByUrls(BaseFetcherWithJsoup fetcherWithJsoup, String[] articleUrls) {
        return fetcherWithJsoup.fetchChapter(fetcherWithJsoup.parseUrlsToIds(articleUrls));
    }
*/

}

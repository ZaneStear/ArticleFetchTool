package com.stear.parent;

import com.stear.bean.ArticleBean;
import com.stear.bean.ChapterBean;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 该类对{@link BaseFetcher}进行进一步实现，借用Jsoup库来解析文章.
 * 子类可传入文章Url，通过{@link #getArticleDocument()}获取{@link Document}.进行解析.
 * 具体解析还是要重写Fetcher中的方法
 *
 * @author Stear
 */
public abstract class BaseFetcherWithJsoup extends BaseFetcher {
    private Document articleDocument;

    protected final Document getArticleDocument() {
        return this.articleDocument;
    }

    /**
     * 该方法作为回调函数，在抓取文章前文章时被调用
     * @param currentId 当前抓取的文章id
     */
    @Override
    protected final void notifyArticle(String currentId) {
        notifyDocument(parseIdToUrl(currentId));
    }

    /**
     * 验证url是否合法，重写此方法可自定义验证规则
     * @param articleUrl 文章url
     * @return true为合法
     */
    protected boolean urlValidation(String articleUrl){
        return true;
    }

    /**
     * 文章url转id,url与id互转的方法必须实现，以便能通过或url来解析文章.
     * @param articleUrl url
     * @return id
     */
    public abstract String parseUrlToId(String articleUrl);

    /**
     * 文章id转url,详情见{@link #parseUrlToId(String articleUrl)}
     * @param articleId id
     * @return url
     */
    public abstract String parseIdToUrl(String articleId);

    /**
     * 批量文章url转id
     * @param articleUrls urls
     * @return ids
     */
    public final String[] parseUrlsToIds(String[] articleUrls) {
        String[] ids = new String[articleUrls.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = parseUrlToId(articleUrls[i]);
        }
        return ids;
    }

    /**
     * 批量文章id转url
     * @param articleIds ids
     * @return urls
     */
    public final String[] parseIdsToUrls(String[] articleIds) {
        String[] urls = new String[articleIds.length];
        for (int i = 0; i < urls.length; i++) {
            urls[i] = parseIdToUrl(articleIds[i]);
        }
        return urls;
    }

    /**
     * 更新文章url，抓取文章前调用.
     * @param url 文章url
     * @return 文章id
     */
    @SneakyThrows
    protected final String notifyDocument(String url) {
        if (urlValidation(url)) {
            articleDocument = Jsoup.connect(url).get();
        }else {
            throw new Exception(url + "不合法");
        }
        return parseUrlToId(url);
    }

    /**
     * 通过文章url抓取
     * @param url 文章url
     * @return 文章实体
     */
    public ArticleBean fetchArticleByUrl(String url) {
        String id = notifyDocument(url);
        return fetchArticle(id);
    }

    /**
     * 通过多个url抓取多个文章
     * @param articleUrls url数组
     * @return 章节实体
     */
    public ChapterBean fetchChapterByUrls(String[] articleUrls) {
        return fetchChapter(parseUrlsToIds(articleUrls));
    }


}

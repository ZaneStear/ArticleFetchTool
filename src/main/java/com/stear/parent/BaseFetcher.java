package com.stear.parent;

import com.stear.bean.ArticleBean;
import com.stear.bean.BookBean;
import com.stear.bean.ChapterBean;
import lombok.NonNull;
import lombok.SneakyThrows;

/**
 * 抓取功能的抽象父类，具体逻辑待子类实现.
 *
 * <p>关于方法从重写，必须重写的有{@link #setArticleContent(String)},这个方法是实现抓取的核心.</p>
 * <p>可选择重写以下方法,可增强功能.</p>
 * 重写{@link #parseChapterId(String chapterId)}和{@link #parseBookId(String bookId)}完成抓取一章或一本书的功能.
 *
 * @author Stear
 * @since 2021.8
 * @version 1.0
 */
public abstract class BaseFetcher {

    /**
     * 回调函数，文章开始抓取时该方法被调用.
     * @param currentId 当前抓取的文章id
     */
    protected void notifyArticle(String currentId) {

    }

    /**
     * 通过传入文章Id来抓取一篇文章
     *
     * @param articleId 文章Id
     * @return EssayBean文章实体
     */
    protected final ArticleBean fetchArticle(String articleId) {
        notifyArticle(articleId);
        ArticleBean articleBean = new ArticleBean();
        articleBean.setArticleId(articleId);
        articleBean.setArticleTitle(setArticleTitle());
        articleBean.setArticleAuthor(setArticleAuthor());
        articleBean.setArticleContent(setArticleContent(articleId));
        return articleBean;
    }

    /**
     * 通过传入文章Id数组来抓取多个文章，并组组装成一个章节（ChapterBean）
     *
     * @param articleIds 多个文章Id
     * @return 一章（ChapterBean）
     */
    protected final ChapterBean fetchChapter(@NonNull String[] articleIds) {
        ChapterBean chapterBean = new ChapterBean();
        chapterBean.setChapterId("Unknown ChapterId");
        chapterBean.setChapterTitle(setChapterTitle());
        for (String id :
                articleIds) {
            chapterBean.addArticleBean(fetchArticle(id));
        }
        return chapterBean;
    }

    /**
     * 通过传入章节Id来抓取一个章节的所有文章.
     * 想使用此功能，子类必须重写并实现{@link #parseChapterId(String chapterId)}
     *
     * @param chapterId 章节Id
     * @return 一个章节（ChapterBean）
     */
    public final ChapterBean fetchChapter(String chapterId) {
        return fetchChapter(parseChapterId(chapterId));
    }

    /**
     * 子类实现此重写此方法，并实现通过章节Id解析出其中所有文章Id
     *
     * @param chapterId 章节Id
     * @return 所有文章Id
     */
    @SneakyThrows
    protected String[] parseChapterId(String chapterId) {
        throw new Exception("该类不支持通过文章Id进行解析");
    }

    /**
     * 章节id数组抓取一本书
     * @param chapterIds 所有章节id
     * @return BookBean实体
     */
    protected final BookBean fetchBook(String[] chapterIds) {
        BookBean bookBean = new BookBean();
        bookBean.setBookId("Unknown BookId");
        bookBean.setBookTitle(setBookTitle());
        bookBean.setBookAuthor(setBookAuthor());
        for (String chapterId :
                chapterIds) {
            bookBean.addChapterBean(fetchChapter(chapterId));
        }
        return bookBean;
    }

    /**
     * 通过传入章节Id来抓取一个章节的所有文章.
     * 想使用此功能，子类必须重写并实现{@link #parseBookId(String bookId)}
     * @param bookId 书id
     * @return BookBean实体
     */
    public final BookBean fetchBook(String bookId) {
        return fetchBook(parseBookId(bookId));
    }

    /**
     * 子类实现此重写此方法，并实现通过书Id解析出其中所有章节Id
     * @param bookId 书id
     * @return 章节id数组
     */
    @SneakyThrows
    protected String[] parseBookId(String bookId) {
        throw new Exception("该类不支持通过书Id进行解析");
    }

    /**
     * 设置文章标题
     *
     * @return 文章标题
     */
    protected String setArticleTitle() {
        return "Unknown EssayTitle";
    }

    /**
     * 设置文章作者
     * @return 作者名
     */
    protected String setArticleAuthor() {
        return "Unknown EssayAuthor";
    }

    /**
     * 在此方法中抓取文章内容，返回文章内容.
     * @return 文章内容
     * @param articleId 文章id
     */
    protected abstract String setArticleContent(String articleId);

    /**
     * 设置章节标题
     *
     * @return 章节标题
     */
    protected String setChapterTitle() {
        return "Unknown ChapterTitle";
    }

    /**
     * 设置书标题
     *
     * @return 书标题
     */
    protected String setBookTitle() {
        return "Unknown BookTitle";
    }

    /**
     * 设置书作者
     *
     * @return 书作者
     */
    protected String setBookAuthor() {
        return "Unknown BookAuthor";
    }


}

package com.stear.domain;

import com.stear.bean.ArticleBean;
import com.stear.bean.ChapterBean;
import com.stear.impl.BaiDuPostBarFetcher;
import com.stear.impl.BiliFetcher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Stear
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BiliFetcher fetcher = new BiliFetcher();
        ChapterBean chapterBean = fetcher.fetchColumn("399220");
        List<ArticleBean> articleBeans = chapterBean.getArticleBeanList();
        StringBuilder stringBuilder = new StringBuilder();
        for (ArticleBean a :
                articleBeans) {

            stringBuilder.append(a.getArticleContent());
        }
        Files.writeString(Path.of("D:\\JavaWorkSpace\\t","overlord同人,东征.txt"),stringBuilder.toString(), StandardCharsets.UTF_8);
    }

}

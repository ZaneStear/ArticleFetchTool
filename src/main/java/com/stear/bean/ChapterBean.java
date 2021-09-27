package com.stear.bean;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stear
 */
@Getter
@Setter
@ToString
public class ChapterBean {
    private String chapterId;
    private String chapterTitle;
    private List<ArticleBean> articleBeanList =new ArrayList<>();

    public void addArticleBean(ArticleBean articleBean) {
        articleBeanList.add(articleBean);
    }
}

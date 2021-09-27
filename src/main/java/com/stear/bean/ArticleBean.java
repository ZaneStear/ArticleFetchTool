package com.stear.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Stear
 */
@Getter
@Setter
@ToString
public class ArticleBean {
    private String articleId;
    private String articleTitle;
    private String articleAuthor;
    private String articleContent;
}

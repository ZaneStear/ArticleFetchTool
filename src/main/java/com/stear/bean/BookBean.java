package com.stear.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stear
 */
@Getter
@Setter
@ToString
public class BookBean {
    private String bookId;
    private String bookTitle;
    private String bookAuthor;
    private List<ChapterBean> chapterBeanList = new ArrayList<>();

    public void addChapterBean(ChapterBean chapterBean) {
        chapterBeanList.add(chapterBean);
    }
}

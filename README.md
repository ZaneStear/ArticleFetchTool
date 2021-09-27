# ArticleFetchTool

#### 简介
抓取网页文章，支持百度贴吧，BiliBili(支持单个文章，专栏文集)，轻之国度。

#### 该项目使用到以下maven依赖
```xml
<dependencies>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.20</version>
    </dependency>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.7</version>
    </dependency>
    <dependency>
        <groupId>org.jsoup</groupId>
        <artifactId>jsoup</artifactId>
        <version>1.14.1</version>
    </dependency>
</dependencies>
```

# 使用说明
##### 1.下载jar文件
##### 2.快速使用
```java

public class FetchExample {
    public static void main(String[] args) {
        //拿到Fetcher实例
        BaseFetcherWithJsoup fetcher = new BiliFetcher();
        //抓取文章
        ArticleBean articleBean = fetcher.fetchArticle("文章id");
        //抓取bilibili专栏文集
        ChapterBean chapterBean = fetcher.fetchColumn("文集id");
    }
}
```

##### 详细使用方法，见doc文档
https://zanestear.github.io/

# 非常易于扩展功能
如果想实现新的抓取功能，只需要新建类并继承BaseFetcher或者BaseFetcherWithJsoup，实现其中的方法则可以完成。
```java
public class MyFetcher extends BaseFetcherWithJsoup {

    @Override
    protected String setArticleContent(String articleId) {
        //完成抓取逻辑
        return null;
    }

    @Override
    public String parseUrlToId(String articleUrl) {
        //完成url转id代码
        return null;
    }

    @Override
    public String parseIdToUrl(String articleId) {
        //完成id转url代码
        return null;
    }
}
```

# 参与贡献
2021.8 ZaneStear


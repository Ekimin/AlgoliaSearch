package com.wentuotuo.algolia.model;

/**
 * Created by ymhe on 2017/3/1.
 * AlgoliaSearch
 */
public class Hexo {
    private String objectID;
    private String title;
    private String date;
    private String slug;
    private String path;
    private String content;

    public void print(){
        //System.out.println("objectID: " + objectID);
        System.out.println("title: " + title);
        System.out.println("date: " + date);
        System.out.println("slug: " + slug);
        System.out.println("path: " + path);
        //System.out.println("content: " + content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

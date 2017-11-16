package com.radionov.nyreaderspidertest.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * ArticleDto dto class for gson deserialization
 */

public class ArticleDto {
    @Expose
    private String section;

    @Expose
    private String title;

    @Expose
    @SerializedName("abstract")
    private String abstractText;

    @Expose
    private String url;

    @Expose
    private String byline;

    @Expose
    @SerializedName("thumbnail_standard")
    private String thumbnail;

    @Expose
    @SerializedName("published_date")
    private Date publishedDate;

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "section='" + section + '\'' +
                ", title='" + title + '\'' +
                ", abstractText='" + abstractText + '\'' +
                ", url='" + url + '\'' +
                ", byline='" + byline + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}

package com.example.mvp_funystory.View.activity;

import android.graphics.Bitmap;

import com.example.mvp_funystory.Model.Categories;

import java.util.List;

public final class StorageCommon {
    private int idStory;
    private int idCate;
    private String chapterStory;
    private String sendBM;
    private List<Categories> listCate;
    private String tagFrag;

    public String getTagFrag() {
        return tagFrag;
    }

    public void setTagFrag(String tagFrag) {
        this.tagFrag = tagFrag;
    }

    public List<Categories> getListCate() {
        return listCate;
    }

    public void setListCate(List<Categories> listCate) {
        this.listCate = listCate;
    }

    public String getSendBM() {
        return sendBM;
    }

    public void setSendBM(String sendBM) {
        this.sendBM = sendBM;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }

    public int getIdStory() {
        return idStory;
    }

    public String getChapterStory() {
        return chapterStory;
    }

    public void setChapterStory(String chapterStory) {
        this.chapterStory = chapterStory;
    }

    public void setIdCate(int id) {
       idCate = id;
    }

    public int getIdCate() {
        return idCate;
    }
}

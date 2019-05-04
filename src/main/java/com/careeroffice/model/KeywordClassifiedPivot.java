package com.careeroffice.model;

public class KeywordClassifiedPivot {

    private int keywordId;

    private int classifiedId;

    public KeywordClassifiedPivot() {
    }

    public KeywordClassifiedPivot( int keywordId, int classifiedId ) {
        this.keywordId = keywordId;
        this.classifiedId = classifiedId;
    }

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId( int keywordId ) {
        this.keywordId = keywordId;
    }

    public int getClassifiedId() {
        return classifiedId;
    }

    public void setClassifiedId( int classifiedId ) {
        this.classifiedId = classifiedId;
    }
}
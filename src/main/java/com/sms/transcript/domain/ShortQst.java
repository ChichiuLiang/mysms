package com.sms.transcript.domain;

/**
 * @author Chichiu
 * @date 2020/6/14 6:20
 */
public class ShortQst {
    private Integer shortid;
    private Integer shortnumber;
    private String shorttitle;
    private String shortanswer;
    private Integer shortscore;

    public Integer getShortid() {
        return shortid;
    }

    public void setShortid(Integer shortid) {
        this.shortid = shortid;
    }

    public Integer getShortnumber() {
        return shortnumber;
    }

    public void setShortnumber(Integer shortnumber) {
        this.shortnumber = shortnumber;
    }

    public String getShortanswer() {
        return shortanswer;
    }

    public void setShortanswer(String shortanswer) {
        this.shortanswer = shortanswer;
    }

    public String getShorttitle() {
        return shorttitle;
    }

    public void setShorttitle(String shorttitle) {
        this.shorttitle = shorttitle;
    }

    public Integer getShortscore() {
        return shortscore;
    }

    public void setShortscore(Integer shortscore) {
        this.shortscore = shortscore;
    }

    @Override
    public String toString() {
        return "[shortid:" + shortid + ",shorttitle:" + shorttitle + ",shortanswer:" + shortanswer + ",shortscore" + shortscore + "]";
    }
}

package com.sms.transcript.domain;

/**
 * @author Chichiu
 * @date 2020/6/15 11:07
 */
public class Transcript {
    private Integer transcriptid;
    private Integer score;
    private String username;
    private String mychoiceanswer;
    private String myshortanswer;
    private String shortanswer;
    private String choiceanswer;
    private Integer choicenum;
    private Integer shortnum;
    private Integer shortscore;
    private Integer choicescore;

    public Integer getTranscriptid() {
        return transcriptid;
    }

    public void setTranscriptid(Integer transcriptid) {
        this.transcriptid = transcriptid;
    }

    public Integer getChoicenum() {
        return choicenum;
    }

    public void setChoicenum(Integer choicenum) {
        this.choicenum = choicenum;
    }

    public Integer getShortnum() {
        return shortnum;
    }

    public void setShortnum(Integer shortnum) {
        this.shortnum = shortnum;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getChoicescore() {
        return choicescore;
    }

    public void setChoicescore(Integer choicescore) {
        this.choicescore = choicescore;
    }

    public Integer getShortscore() {
        return shortscore;
    }

    public void setShortscore(Integer shortscore) {
        this.shortscore = shortscore;
    }

    public String getShortanswer() {
        return shortanswer;
    }

    public void setShortanswer(String shortanswer) {
        this.shortanswer = shortanswer;
    }

    public String getChoiceanswer() {
        return choiceanswer;
    }

    public void setChoiceanswer(String choiceanswer) {
        this.choiceanswer = choiceanswer;
    }

    public String getMychoiceanswer() {
        return mychoiceanswer;
    }

    public void setMychoiceanswer(String mychoiceanswer) {
        this.mychoiceanswer = mychoiceanswer;
    }

    public String getMyshortanswer() {
        return myshortanswer;
    }

    public void setMyshortanswer(String myshortanswer) {
        this.myshortanswer = myshortanswer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}

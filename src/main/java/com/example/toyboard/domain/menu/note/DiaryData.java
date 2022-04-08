package com.example.toyboard.domain.menu.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_NOTE_DIARY",schema = "TOY")
public class DiaryData {

    @Column(name = "authorty")
    String authority;

    @Column(name = "diary_dtm")
    String diaryDtm;

    @Column(name = "diary_title")
    String diaryTitle;

    @Column(name = "diary_condition")
    String diaryCondition;

    @Column(name = "diary_weather")
    String diaryWeather;

    @Column(name = "diary_photo")
    String diaryPhoto;

    @Column(name = "dairy_private")
    String diaryPrivate;

    @Column(name = "diary_id")
    @Id
    String diaryId;

    public DiaryData(String authority, String diaryDtm, String diaryTitle, String diaryCondition, String diaryWeather, String diaryPhoto, String diaryPrivate, String diaryId) {
        this.authority = authority;
        this.diaryDtm = diaryDtm;
        this.diaryTitle = diaryTitle;
        this.diaryCondition = diaryCondition;
        this.diaryWeather = diaryWeather;
        this.diaryPhoto = diaryPhoto;
        this.diaryPrivate = diaryPrivate;
        this.diaryId = diaryId;
    }

    public DiaryData() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getDiaryDtm() {
        return diaryDtm;
    }

    public void setDiaryDtm(String diaryDtm) {
        this.diaryDtm = diaryDtm;
    }

    public String getDiaryTitle() {
        return diaryTitle;
    }

    public void setDiaryTitle(String diaryTitle) {
        this.diaryTitle = diaryTitle;
    }

    public String getDiaryCondition() {
        return diaryCondition;
    }

    public void setDiaryCondition(String diaryCondition) {
        this.diaryCondition = diaryCondition;
    }

    public String getDiaryWeather() {
        return diaryWeather;
    }

    public void setDiaryWeather(String diaryWeather) {
        this.diaryWeather = diaryWeather;
    }

    public String getDiaryPhoto() {
        return diaryPhoto;
    }

    public void setDiaryPhoto(String diaryPhoto) {
        this.diaryPhoto = diaryPhoto;
    }

    public String getDiaryPrivate() {return diaryPrivate;}

    public void setDiaryPrivate(String diaryPrivate) {this.diaryPrivate = diaryPrivate;}

    public String getDiaryId() {return diaryId;}

    public void setDiaryId(String diaryId) {this.diaryId = diaryId;}

    @Override
    public String toString() {
        return "DiaryData{" +
                "authority='" + authority + '\'' +
                ", diaryDtm='" + diaryDtm + '\'' +
                ", diaryTitle='" + diaryTitle + '\'' +
                ", diaryCondition='" + diaryCondition + '\'' +
                ", diaryWeather='" + diaryWeather + '\'' +
                ", diaryPhoto='" + diaryPhoto + '\'' +
                ", diaryPrivate='" + diaryPrivate + '\'' +
                ", diaryId='" + diaryId + '\'' +
                '}';
    }
}

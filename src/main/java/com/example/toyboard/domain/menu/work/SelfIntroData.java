package com.example.toyboard.domain.menu.work;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MENU_WORK_SELF_INTRO",schema = "TOY")
public class SelfIntroData {

    @Column(name = "one_line_intro")
    String oneLineIntro;

    @Column(name = "intro_id")
    @Id
    String introId;

    @Column(name = "self_intro")
    String selfIntro;

    @Column(name="aspiration")
    String aspiration;

    @Column(name="personality")
    String personality;

    @Column(name="etc_title1")
    String etcTitle1;

    @Column(name="etc_content1")
    String etcContent1;

    @Column(name="etc_title2")
    String etcTitle2;

    @Column(name="etc_content2")
    String etcContent2;

    @Column(name = "authority")
    String authority;

    @Column(name = "reg_dtm")
    String regDtm;

    @Column(name="user_id")
    String userId;

    public SelfIntroData(String oneLineIntro, String introId, String selfIntro, String aspiration, String personality, String etcTitle1, String etcContent1, String etcTitle2, String etcContent2, String authority, String regDtm, String userId) {
        this.oneLineIntro = oneLineIntro;
        this.introId = introId;
        this.selfIntro = selfIntro;
        this.aspiration = aspiration;
        this.personality = personality;
        this.etcTitle1 = etcTitle1;
        this.etcContent1 = etcContent1;
        this.etcTitle2 = etcTitle2;
        this.etcContent2 = etcContent2;
        this.authority = authority;
        this.regDtm = regDtm;
        this.userId = userId;
    }

    public SelfIntroData() {
    }

    public void compareAndChangeData(SelfIntroData selfIntroData){
        if(!this.oneLineIntro.equals(selfIntroData.getOneLineIntro())){
            this.oneLineIntro = selfIntroData.getOneLineIntro();
        }
        if(!this.selfIntro.equals(selfIntroData.getSelfIntro())){
            this.selfIntro = selfIntroData.getSelfIntro();
        }
        if(!this.aspiration.equals(selfIntroData.getAspiration())){
            this.aspiration = selfIntroData.getAspiration();
        }
        if(!this.personality.equals(selfIntroData.getPersonality())){
            this.personality = selfIntroData.getPersonality();
        }
        if(!this.etcTitle1.equals(selfIntroData.getEtcTitle1())){
            this.etcTitle1 = selfIntroData.getEtcTitle1();
        }
        if(!this.etcContent1.equals(selfIntroData.getEtcContent1())){
            this.etcContent1 = selfIntroData.getEtcContent1();
        }
        if(!this.etcTitle2.equals(selfIntroData.getEtcTitle2())){
            this.etcTitle2 = selfIntroData.getEtcTitle2();
        }
        if(!this.etcContent2.equals(selfIntroData.getEtcContent2())){
            this.etcContent2 = selfIntroData.getEtcContent2();
        }
        if(!this.regDtm.equals(selfIntroData.getRegDtm())){
            this.regDtm = selfIntroData.getRegDtm();
        }
    }

    public String getOneLineIntro() {
        return oneLineIntro;
    }

    public void setOneLineIntro(String oneLineIntro) {
        this.oneLineIntro = oneLineIntro;
    }

    public String getIntroId() {
        return introId;
    }

    public void setIntroId(String introId) {
        this.introId = introId;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    public String getAspiration() {
        return aspiration;
    }

    public void setAspiration(String aspiration) {
        this.aspiration = aspiration;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getEtcTitle1() {
        return etcTitle1;
    }

    public void setEtcTitle1(String etcTitle1) {
        this.etcTitle1 = etcTitle1;
    }

    public String getEtcContent1() {
        return etcContent1;
    }

    public void setEtcContent1(String etcContent1) {
        this.etcContent1 = etcContent1;
    }

    public String getEtcTitle2() {
        return etcTitle2;
    }

    public void setEtcTitle2(String etcTitle2) {
        this.etcTitle2 = etcTitle2;
    }

    public String getEtcContent2() {
        return etcContent2;
    }

    public void setEtcContent2(String etcContent2) {
        this.etcContent2 = etcContent2;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getRegDtm() {
        return regDtm;
    }

    public void setRegDtm(String regDtm) {
        this.regDtm = regDtm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SelfIntroData{" +
                "oneLineIntro='" + oneLineIntro + '\'' +
                ", introId='" + introId + '\'' +
                ", selfIntro='" + selfIntro + '\'' +
                ", aspiration='" + aspiration + '\'' +
                ", personality='" + personality + '\'' +
                ", etcTitle1='" + etcTitle1 + '\'' +
                ", etcContent1='" + etcContent1 + '\'' +
                ", etcTitle2='" + etcTitle2 + '\'' +
                ", etcContent2='" + etcContent2 + '\'' +
                ", authority='" + authority + '\'' +
                ", regDtm='" + regDtm + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}

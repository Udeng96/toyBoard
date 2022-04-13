package com.example.toyboard.domain.menu.work;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_WORK_PROJECT",schema = "TOY")
public class WorkProjectData {

    @Column(name = "w_project_id")
    @Id
    String wProjectId;

    @Column(name = "user_id")
    String userId;

    @Column(name="company_id")
    String companyId;

    @Column(name="w_project_title")
    String wProjectTitle;

    @Column(name="w_project_photo")
    String wProjectPhoto;

    @Column(name="w_project_start_dtm")
    String wProjectStartDtm;

    @Column(name = "w_project_end_dtm")
    String wProjectEndDtm;

    @Column(name = "w_project_team")
    String wProjectTeam;

    @Column(name = "w_project_content")
    String wProjectContent;

    @Column(name = "authority")
    String authority;

    @Column(name = "w_project_stack")
    String wProjectStack;

    public WorkProjectData(String wProjectId, String userId, String companyId, String wProjectTitle, String wProjectPhoto, String wProjectStartDtm, String wProjectEndDtm, String wProjectTeam, String wProjectContent, String authority, String wProjectStack) {
        this.wProjectId = wProjectId;
        this.userId = userId;
        this.companyId = companyId;
        this.wProjectTitle = wProjectTitle;
        this.wProjectPhoto = wProjectPhoto;
        this.wProjectStartDtm = wProjectStartDtm;
        this.wProjectEndDtm = wProjectEndDtm;
        this.wProjectTeam = wProjectTeam;
        this.wProjectContent = wProjectContent;
        this.authority = authority;
        this.wProjectStack = wProjectStack;
    }

    public WorkProjectData() {
    }

    public void compareAndChangeData(WorkProjectData workProjectData){

    }

    public String getwProjectId() {
        return wProjectId;
    }

    public void setwProjectId(String wProjectId) {
        this.wProjectId = wProjectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getwProjectTitle() {
        return wProjectTitle;
    }

    public void setwProjectTitle(String wProjectTitle) {
        this.wProjectTitle = wProjectTitle;
    }

    public String getwProjectPhoto() {
        return wProjectPhoto;
    }

    public void setwProjectPhoto(String wProjectPhoto) {
        this.wProjectPhoto = wProjectPhoto;
    }

    public String getwProjectStartDtm() {
        return wProjectStartDtm;
    }

    public void setwProjectStartDtm(String wProjectStartDtm) {
        this.wProjectStartDtm = wProjectStartDtm;
    }

    public String getwProjectEndDtm() {
        return wProjectEndDtm;
    }

    public void setwProjectEndDtm(String wProjectEndDtm) {
        this.wProjectEndDtm = wProjectEndDtm;
    }

    public String getwProjectTeam() {
        return wProjectTeam;
    }

    public void setwProjectTeam(String wProjectTeam) {
        this.wProjectTeam = wProjectTeam;
    }

    public String getwProjectContent() {
        return wProjectContent;
    }

    public void setwProjectContent(String wProjectContent) {
        this.wProjectContent = wProjectContent;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getwProjectStack() {
        return wProjectStack;
    }

    public void setwProjectStack(String wProjectStack) {
        this.wProjectStack = wProjectStack;
    }

    @Override
    public String toString() {
        return "WorkProjectData{" +
                "wProjectId='" + wProjectId + '\'' +
                ", userId='" + userId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", wProjectTitle='" + wProjectTitle + '\'' +
                ", wProjectPhoto='" + wProjectPhoto + '\'' +
                ", wProjectStartDtm='" + wProjectStartDtm + '\'' +
                ", wProjectEndDtm='" + wProjectEndDtm + '\'' +
                ", wProjectTeam='" + wProjectTeam + '\'' +
                ", wProjectContent='" + wProjectContent + '\'' +
                ", authority='" + authority + '\'' +
                ", wProjectStack='" + wProjectStack + '\'' +
                '}';
    }
}

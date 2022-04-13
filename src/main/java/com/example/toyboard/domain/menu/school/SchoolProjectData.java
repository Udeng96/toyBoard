package com.example.toyboard.domain.menu.school;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_SCHOOL_PROJECT",schema = "TOY")
public class SchoolProjectData {

    @Column(name = "s_project_id")
    @Id
    String sProjectId;

    @Column(name = "user_Id")
    String userId;

    @Column(name = "subject_id")
    String subjectId;

    @Column(name = "school_id")
    String schoolId;

    @Column(name = "s_project_title")
    String sProjectTitle;

    @Column(name = "s_project_photo")
    String sProjectPhoto;

    @Column(name = "s_project_team")
    String sProjectTeam;

    @Column(name = "s_project_stack")
    String sProjectStack;

    @Column(name = "s_project_content")
    String sProjectContent;

    @Column(name = "s_project_start_dtm")
    String sProjectStartDtm;

    @Column(name = "s_project_end_dtm")
    String sProjectEndDtm;

    @Column(name = "s_project_role")
    String sProjectRole;

    @Column(name = "authority")
    String authority;


    public SchoolProjectData(String sProjectId, String userId, String subjectId, String schoolId, String sProjectTitle, String sProjectPhoto, String sProjectTeam, String sProjectStack, String sProjectContent, String sProjectStartDtm, String sProjectEndDtm, String sProjectRole, String authority) {
        this.sProjectId = sProjectId;
        this.userId = userId;
        this.subjectId = subjectId;
        this.schoolId = schoolId;
        this.sProjectTitle = sProjectTitle;
        this.sProjectPhoto = sProjectPhoto;
        this.sProjectTeam = sProjectTeam;
        this.sProjectStack = sProjectStack;
        this.sProjectContent = sProjectContent;
        this.sProjectStartDtm = sProjectStartDtm;
        this.sProjectEndDtm = sProjectEndDtm;
        this.sProjectRole = sProjectRole;
        this.authority = authority;
    }

    public SchoolProjectData() {
    }

    public String getsProjectId() {
        return sProjectId;
    }

    public void setsProjectId(String sProjectId) {
        this.sProjectId = sProjectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getsProjectTitle() {
        return sProjectTitle;
    }

    public void setsProjectTitle(String sProjectTitle) {
        this.sProjectTitle = sProjectTitle;
    }

    public String getsProjectPhoto() {
        return sProjectPhoto;
    }

    public void setsProjectPhoto(String sProjectPhoto) {
        this.sProjectPhoto = sProjectPhoto;
    }

    public String getsProjectTeam() {
        return sProjectTeam;
    }

    public void setsProjectTeam(String sProjectTeam) {
        this.sProjectTeam = sProjectTeam;
    }

    public String getsProjectStack() {
        return sProjectStack;
    }

    public void setsProjectStack(String sProjectStack) {
        this.sProjectStack = sProjectStack;
    }

    public String getsProjectContent() {
        return sProjectContent;
    }

    public void setsProjectContent(String sProjectContent) {
        this.sProjectContent = sProjectContent;
    }

    public String getsProjectStartDtm() {
        return sProjectStartDtm;
    }

    public void setsProjectStartDtm(String sProjectStartDtm) {
        this.sProjectStartDtm = sProjectStartDtm;
    }

    public String getsProjectEndDtm() {
        return sProjectEndDtm;
    }

    public void setsProjectEndDtm(String sProjectEndDtm) {
        this.sProjectEndDtm = sProjectEndDtm;
    }

    public String getsProjectRole() {
        return sProjectRole;
    }

    public void setsProjectRole(String sProjectRole) {
        this.sProjectRole = sProjectRole;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "SchoolProjectData{" +
                "sProjectId='" + sProjectId + '\'' +
                ", userId='" + userId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", sProjectTitle='" + sProjectTitle + '\'' +
                ", sProjectPhoto='" + sProjectPhoto + '\'' +
                ", sProjectTeam='" + sProjectTeam + '\'' +
                ", sProjectStack='" + sProjectStack + '\'' +
                ", sProjectContent='" + sProjectContent + '\'' +
                ", sProjectStartDtm='" + sProjectStartDtm + '\'' +
                ", sProjectEndDtm='" + sProjectEndDtm + '\'' +
                ", sProjectRole='" + sProjectRole + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}

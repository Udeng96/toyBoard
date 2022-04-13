package com.example.toyboard.domain.menu.school;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MENU_SCHOOL_SUBJECT",schema = "TOY")
public class SchoolSubjectData {

    @Column(name="subject_id")
    @Id
    String subjectId;

    @Column(name = "school_id")
    String schoolId;

    @Column(name = "user_id")
    String userId;

    @Column(name = "subject_name")
    String subjectName;

    @Column(name="subject_semester")
    String subjectSemester;

    @Column(name="subject_score")
    String subjectScore;

    @Column(name = "subject_major_yn")
    String subjectMajorYn;

    @Column(name = "authority")
    String authority;

    public SchoolSubjectData(String subjectId, String schoolId, String userId, String subjectName, String subjectSemester, String subjectScore, String subjectMajorYn, String authority) {
        this.subjectId = subjectId;
        this.schoolId = schoolId;
        this.userId = userId;
        this.subjectName = subjectName;
        this.subjectSemester = subjectSemester;
        this.subjectScore = subjectScore;
        this.subjectMajorYn = subjectMajorYn;
        this.authority = authority;
    }

    public SchoolSubjectData() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectSemester() {
        return subjectSemester;
    }

    public void setSubjectSemester(String subjectSemester) {
        this.subjectSemester = subjectSemester;
    }

    public String getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(String subjectScore) {
        this.subjectScore = subjectScore;
    }

    public String getSubjectMajorYn() {
        return subjectMajorYn;
    }

    public void setSubjectMajorYn(String subjectMajorYn) {
        this.subjectMajorYn = subjectMajorYn;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "SchoolSubjectData{" +
                "subjectId='" + subjectId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", userId='" + userId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", subjectSemester='" + subjectSemester + '\'' +
                ", subjectScore='" + subjectScore + '\'' +
                ", subjectMajorYn='" + subjectMajorYn + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}

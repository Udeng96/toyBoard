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

    @Column(name = "school_nm")
    String schoolNm;

    // H : High / U : University / G : Grad
    @Column(name = "school_type")
    String schoolType;

    public SchoolSubjectData(String subjectId, String schoolId, String userId, String subjectName, String subjectSemester, String subjectScore, String subjectMajorYn, String authority, String schoolNm, String schoolType) {
        this.subjectId = subjectId;
        this.schoolId = schoolId;
        this.userId = userId;
        this.subjectName = subjectName;
        this.subjectSemester = subjectSemester;
        this.subjectScore = subjectScore;
        this.subjectMajorYn = subjectMajorYn;
        this.authority = authority;
        this.schoolNm = schoolNm;
        this.schoolType = schoolType;
    }

    public SchoolSubjectData() {
    }

    public void compareAndChangeData(SchoolSubjectData obj){
        if(!this.subjectName.equals(obj.getSubjectName())){
            this.subjectName = obj.getSubjectName();
        }
        if(!this.subjectSemester.equals(obj.getSubjectSemester())){
            this.subjectSemester = obj.getSubjectSemester();
        }
        if(!this.subjectScore.equals(obj.getSubjectScore())){
            this.subjectScore = obj.getSubjectScore();
        }
        if(!this.subjectMajorYn.equals(obj.getSubjectMajorYn())){
            this.subjectMajorYn = obj.getSubjectMajorYn();
        }
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

    public String getSchoolNm() {
        return schoolNm;
    }

    public void setSchoolNm(String schoolNm) {
        this.schoolNm = schoolNm;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
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
                ", schoolNm='" + schoolNm + '\'' +
                ", schoolType='" + schoolType + '\'' +
                '}';
    }
}

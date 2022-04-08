package com.example.toyboard.domain.menu.school;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_SCHOOL_EDU",schema = "TOY")
public class SchoolData {

    @Column(name="user_id")
    @Id
    String userId;

    // H : 고등학교 / U : 대학교 / G : 대학원
    @Column(name="last_edu")
    String lastEdu;

    @Column(name = "high_school_nm")
    String highSchoolNm;

    @Column(name = "high_school_enter_dtm")
    String highSchoolEnterDtm;

    @Column(name  = "high_school_grad_dtm")
    String highSchoolGradDtm;

    @Column(name = "university_nm")
    String universityNm;

    @Column(name = "university_dept")
    String universityDept;

    @Column(name="university_enter_dtm")
    String universityEnterDtm;

    @Column(name = "university_grad_dtm")
    String universityGradDtm;

    @Column(name = "grad_school_nm")
    String gradSchoolNm;

    // M : 석사 / D : 박사
    @Column(name = "grad_school_degree")
    String gradSchoolDegree;

    @Column(name = "grad_school_enter_dtm")
    String gradSchoolEnterDtm;

    @Column(name = "grad_school_grad_dtm")
    String gradSchoolGradDtm;


    public SchoolData(String userId, String lastEdu, String highSchoolNm, String highSchoolEnterDtm, String highSchoolGradDtm, String universityNm, String universityDept, String universityEnterDtm, String universityGradDtm, String gradSchoolNm, String gradSchoolDegree, String gradSchoolEnterDtm, String gradSchoolGradDtm, String schoolId) {
        this.userId = userId;
        this.lastEdu = lastEdu;
        this.highSchoolNm = highSchoolNm;
        this.highSchoolEnterDtm = highSchoolEnterDtm;
        this.highSchoolGradDtm = highSchoolGradDtm;
        this.universityNm = universityNm;
        this.universityDept = universityDept;
        this.universityEnterDtm = universityEnterDtm;
        this.universityGradDtm = universityGradDtm;
        this.gradSchoolNm = gradSchoolNm;
        this.gradSchoolDegree = gradSchoolDegree;
        this.gradSchoolEnterDtm = gradSchoolEnterDtm;
        this.gradSchoolGradDtm = gradSchoolGradDtm;
    }

    public SchoolData() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastEdu() {
        return lastEdu;
    }

    public void setLastEdu(String lastEdu) {
        this.lastEdu = lastEdu;
    }

    public String getHighSchoolNm() {
        return highSchoolNm;
    }

    public void setHighSchoolNm(String highSchoolNm) {
        this.highSchoolNm = highSchoolNm;
    }

    public String getHighSchoolEnterDtm() {
        return highSchoolEnterDtm;
    }

    public void setHighSchoolEnterDtm(String highSchoolEnterDtm) {
        this.highSchoolEnterDtm = highSchoolEnterDtm;
    }

    public String getHighSchoolGradDtm() {
        return highSchoolGradDtm;
    }

    public void setHighSchoolGradDtm(String highSchoolGradDtm) {
        this.highSchoolGradDtm = highSchoolGradDtm;
    }

    public String getUniversityNm() {
        return universityNm;
    }

    public void setUniversityNm(String universityNm) {
        this.universityNm = universityNm;
    }

    public String getUniversityDept() {
        return universityDept;
    }

    public void setUniversityDept(String universityDept) {
        this.universityDept = universityDept;
    }

    public String getUniversityEnterDtm() {
        return universityEnterDtm;
    }

    public void setUniversityEnterDtm(String universityEnterDtm) {
        this.universityEnterDtm = universityEnterDtm;
    }

    public String getUniversityGradDtm() {
        return universityGradDtm;
    }

    public void setUniversityGradDtm(String universityGradDtm) {
        this.universityGradDtm = universityGradDtm;
    }

    public String getGradSchoolNm() {
        return gradSchoolNm;
    }

    public void setGradSchoolNm(String gradSchoolNm) {
        this.gradSchoolNm = gradSchoolNm;
    }

    public String getGradSchoolDegree() {
        return gradSchoolDegree;
    }

    public void setGradSchoolDegree(String gradSchoolDegree) {
        this.gradSchoolDegree = gradSchoolDegree;
    }

    public String getGradSchoolEnterDtm() {
        return gradSchoolEnterDtm;
    }

    public void setGradSchoolEnterDtm(String gradSchoolEnterDtm) {
        this.gradSchoolEnterDtm = gradSchoolEnterDtm;
    }

    public String getGradSchoolGradDtm() {
        return gradSchoolGradDtm;
    }

    public void setGradSchoolGradDtm(String gradSchoolGradDtm) {
        this.gradSchoolGradDtm = gradSchoolGradDtm;
    }


    @Override
    public String toString() {
        return "SchoolData{" +
                "userId='" + userId + '\'' +
                ", lastEdu='" + lastEdu + '\'' +
                ", highSchoolNm='" + highSchoolNm + '\'' +
                ", highSchoolEnterDtm='" + highSchoolEnterDtm + '\'' +
                ", highSchoolGradDtm='" + highSchoolGradDtm + '\'' +
                ", universityNm='" + universityNm + '\'' +
                ", universityDept='" + universityDept + '\'' +
                ", universityEnterDtm='" + universityEnterDtm + '\'' +
                ", universityGradDtm='" + universityGradDtm + '\'' +
                ", gradSchoolNm='" + gradSchoolNm + '\'' +
                ", gradSchoolDegree='" + gradSchoolDegree + '\'' +
                ", gradSchoolEnterDtm='" + gradSchoolEnterDtm + '\'' +
                ", gradSchoolGradDtm='" + gradSchoolGradDtm + '\'' +
                '}';
    }
}

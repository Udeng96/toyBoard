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

    @Column(name = "grad_school_dept")
    String gradSchoolDept;
    // M : 석사 / D : 박사
    @Column(name = "grad_school_degree")
    String gradSchoolDegree;

    @Column(name = "grad_school_enter_dtm")
    String gradSchoolEnterDtm;

    @Column(name = "grad_school_grad_dtm")
    String gradSchoolGradDtm;

    @Column(name = "authority")
    String authority;

    @Column(name = "high_school_id")
    String highSchoolId;

    @Column(name = "university_id")
    String universityId;

    @Column(name = "grad_school_id")
    String gradSchoolId;


    public SchoolData(String userId, String lastEdu, String highSchoolNm, String highSchoolEnterDtm, String highSchoolGradDtm, String universityNm, String universityDept, String universityEnterDtm, String universityGradDtm, String gradSchoolNm, String gradSchoolDept, String gradSchoolDegree, String gradSchoolEnterDtm, String gradSchoolGradDtm, String authority, String highSchoolId, String universityId, String gardSchoolId) {
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
        this.gradSchoolDept = gradSchoolDept;
        this.gradSchoolDegree = gradSchoolDegree;
        this.gradSchoolEnterDtm = gradSchoolEnterDtm;
        this.gradSchoolGradDtm = gradSchoolGradDtm;
        this.authority = authority;
        this.highSchoolId = highSchoolId;
        this.universityId = universityId;
        this.gradSchoolId = gardSchoolId;
    }

    public SchoolData() {
    }

    public void compareAndChangeData(SchoolData schoolData){
        if(!this.lastEdu.equals(schoolData.getLastEdu())){
            this.lastEdu = schoolData.getLastEdu();
        }
        if(!this.highSchoolNm.equals(schoolData.getHighSchoolNm())){
            this.highSchoolNm = schoolData.getHighSchoolNm();
            this.highSchoolId = schoolData.getHighSchoolId();
        }
        if(this.highSchoolEnterDtm.equals(schoolData.getGradSchoolEnterDtm())){
            this.highSchoolEnterDtm= schoolData.getHighSchoolEnterDtm();
        }
        if(!this.highSchoolGradDtm.equals(schoolData.getHighSchoolGradDtm())){
            this.highSchoolGradDtm = schoolData.getHighSchoolGradDtm();
        }
        if(!this.universityNm.equals(schoolData.getUniversityNm())){
            this.universityNm = schoolData.getUniversityNm();
            this.universityId = schoolData.getUniversityId();
        }
        if(!this.universityDept.equals(schoolData.getUniversityDept())){
            this.universityDept = schoolData.getUniversityDept();
        }
        if(!this.universityEnterDtm.equals(schoolData.getUniversityEnterDtm())){
            this.universityEnterDtm = schoolData.getUniversityEnterDtm();
        }
        if(!this.universityGradDtm.equals(schoolData.getUniversityGradDtm())){
            this.universityGradDtm = schoolData.getUniversityGradDtm();
        }
        if(!this.gradSchoolNm.equals(schoolData.getGradSchoolNm())){
            this.gradSchoolNm = schoolData.getGradSchoolNm();
            this.gradSchoolId = schoolData.getGradSchoolId();
        }
        if(!this.gradSchoolDept.equals(schoolData.getGradSchoolDept())){
            this.gradSchoolDept = schoolData.getGradSchoolDept();
        }
        if(!this.gradSchoolDegree.equals(schoolData.getGradSchoolDegree())){
            this.gradSchoolDegree = schoolData.getGradSchoolDegree();
        }
        if(!this.gradSchoolEnterDtm.equals(schoolData.getGradSchoolEnterDtm())){
            this.gradSchoolEnterDtm = schoolData.getGradSchoolEnterDtm();
        }
        if(!this.gradSchoolGradDtm.equals(schoolData.getGradSchoolGradDtm())){
            this.gradSchoolGradDtm = schoolData.getGradSchoolGradDtm();
        }
        if(!this.highSchoolId.equals(schoolData.getHighSchoolId())){
            this.highSchoolId = schoolData.getHighSchoolId();
        }
        if(!this.universityId.equals(schoolData.getUniversityId())){
            this.universityId = schoolData.getUniversityId();
        }
        if(!this.gradSchoolId.equals(schoolData.getGradSchoolId())){
            this.gradSchoolId = schoolData.getGradSchoolId();
        }
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

    public String getGradSchoolDept() {
        return gradSchoolDept;
    }

    public void setGradSchoolDept(String gradSchoolDept) {
        this.gradSchoolDept = gradSchoolDept;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getHighSchoolId() {
        return highSchoolId;
    }

    public void setHighSchoolId(String highSchoolId) {
        this.highSchoolId = highSchoolId;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public String getGradSchoolId() {
        return gradSchoolId;
    }

    public void setGradSchoolId(String gardSchoolId) {
        this.gradSchoolId = gardSchoolId;
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
                ", gradSchoolDept='" + gradSchoolDept + '\'' +
                ", gradSchoolDegree='" + gradSchoolDegree + '\'' +
                ", gradSchoolEnterDtm='" + gradSchoolEnterDtm + '\'' +
                ", gradSchoolGradDtm='" + gradSchoolGradDtm + '\'' +
                ", authority='" + authority + '\'' +
                ", highSchoolId='" + highSchoolId + '\'' +
                ", universityId='" + universityId + '\'' +
                ", gardSchoolId='" + gradSchoolId + '\'' +
                '}';
    }
}

package com.example.toyboard.domain.menu.work;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_WORK_COMPNAY", schema = "TOY")
public class CompanyData {

    @Column(name = "user_id")
    String userId;

    @Column(name = "company_nm")
    String companyNm;

    @Column(name = "company_addr")
    String companyAddr;

    @Column(name = "rank")
    String rank;

    @Column(name = "dept")
    String dept;

    @Column(name = "profession")
    String profession;

    @Column(name = "salary")
    String salary;

    @Column(name = "join_dtm")
    String joinDtm;

    @Column(name = "leave_dtm")
    String leaveDtm;

    @Column(name = "company_id")
    @Id
    String companyId;

    public CompanyData(String userId, String companyNm, String companyAddr, String rank, String dept, String profession, String salary, String joinDtm, String leaveDtm, String companyId) {
        this.userId = userId;
        this.companyNm = companyNm;
        this.companyAddr = companyAddr;
        this.rank = rank;
        this.dept = dept;
        this.profession = profession;
        this.salary = salary;
        this.joinDtm = joinDtm;
        this.leaveDtm = leaveDtm;
        this.companyId = companyId;
    }

    public CompanyData() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyNm() {
        return companyNm;
    }

    public void setCompanyNm(String companyNm) {
        this.companyNm = companyNm;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJoinDtm() {
        return joinDtm;
    }

    public void setJoinDtm(String joinDtm) {
        this.joinDtm = joinDtm;
    }

    public String getLeaveDtm() {
        return leaveDtm;
    }

    public void setLeaveDtm(String leaveDtm) {
        this.leaveDtm = leaveDtm;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "CompanyData{" +
                "userId='" + userId + '\'' +
                ", companyNm='" + companyNm + '\'' +
                ", companyAddr='" + companyAddr + '\'' +
                ", rank='" + rank + '\'' +
                ", dept='" + dept + '\'' +
                ", profession='" + profession + '\'' +
                ", salary='" + salary + '\'' +
                ", joinDtm='" + joinDtm + '\'' +
                ", leaveDtm='" + leaveDtm + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}

package com.example.toyboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER", schema ="TOY")
public class MemberData {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "birth")
    private String birth;

    @Column(name="phone_num")
    private String phoneNum;

    @Column(name="authority")
    private String authority;

    @Column(name="profile_photo")
    private String profilePhoto;


    public MemberData(String name, String id, String pwd, String birth, String phoneNum, String authority, String profilePhoto) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.birth = birth;
        this.phoneNum = phoneNum;
        this.authority = authority;
        this.profilePhoto = profilePhoto;
    }

    public MemberData() {
    }

    public void compareAndChangeData(MemberData obj){
        if(!this.name.equals(obj.getName())){
            this.name = obj.getName();
        }
        if(!this.pwd.equals(obj.getPwd()) && !obj.getPwd().isEmpty()){
            this.pwd = obj.getPwd();
        }
        if(!this.phoneNum.equals(obj.getPhoneNum())){
            this.phoneNum = obj.getPhoneNum();
        }
        if(!this.profilePhoto.equals(obj.getProfilePhoto()) && obj.getProfilePhoto()!=null){
            this.profilePhoto = obj.getProfilePhoto();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "MemberData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birth='" + birth + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", authority='" + authority + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                '}';
    }
}

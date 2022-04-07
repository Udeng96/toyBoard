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
    @Column(name = "email")
    private String email;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "birth")
    private String birth;

    @Column(name="")

}

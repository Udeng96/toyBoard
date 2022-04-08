package com.example.toyboard.domain.menu.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_NOTE_TODO", schema = "TOY")
public class TodoData {

    @Column(name = "authority")
    String authority;

    @Column(name = "todo_start_dtm")
    String todoStartDtm;

    @Column(name = "todo_end_dtm")
    String todoEndDtm;

    @Column(name = "todo_title")
    String todoTitle;

    @Column(name = "todo_contnent")
    String todoContent;

    @Column(name = "todo_alarm_ym")
    String todoAlarmYn;

    @Column(name = "todo_id")
    @Id
    String todoId;

    public TodoData(String authority, String todoStartDtm, String todoEndDtm, String todoTitle, String todoContent, String todoAlarmYn, String todoId) {
        this.authority = authority;
        this.todoStartDtm = todoStartDtm;
        this.todoEndDtm = todoEndDtm;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.todoAlarmYn = todoAlarmYn;
        this.todoId = todoId;
    }

    public TodoData() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getTodoStartDtm() {
        return todoStartDtm;
    }

    public void setTodoStartDtm(String todoStartDtm) {
        this.todoStartDtm = todoStartDtm;
    }

    public String getTodoEndDtm() {
        return todoEndDtm;
    }

    public void setTodoEndDtm(String todoEndDtm) {
        this.todoEndDtm = todoEndDtm;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public String getTodoAlarmYn() {
        return todoAlarmYn;
    }

    public void setTodoAlarmYn(String todoAlarmYn) {
        this.todoAlarmYn = todoAlarmYn;
    }

    public String getTodoId() {return todoId;}

    public void setTodoId(String todoId) {this.todoId = todoId;}

    @Override
    public String toString() {
        return "TodoData{" +
                "authority='" + authority + '\'' +
                ", todoStartDtm='" + todoStartDtm + '\'' +
                ", todoEndDtm='" + todoEndDtm + '\'' +
                ", todoTitle='" + todoTitle + '\'' +
                ", todoContent='" + todoContent + '\'' +
                ", todoAlarmYn='" + todoAlarmYn + '\'' +
                ", todoId='" + todoId + '\'' +
                '}';
    }
}

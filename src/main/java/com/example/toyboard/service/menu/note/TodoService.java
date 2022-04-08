package com.example.toyboard.service.menu.note;

import com.example.toyboard.dao.menu.note.TodoDao;
import com.example.toyboard.domain.menu.note.TodoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TodoService {

    private static final Logger logger = LoggerFactory.getLogger(TodoService.class);

    @Autowired
    TodoDao todoDao;

    public List<TodoData> getTodayTodoList(String authority, String todoId){

        String todayDtm = getTodayDate();
        return todoDao.selectTodo(authority, todayDtm, todoId);

    }

    //todo : front에서 종일인경우 startTime 0000 endTime 2400으로 넣기
    public boolean addTodayTodo(TodoData todoData){


        String startDtm = getTodayDate()+todoData.getTodoStartDtm();
        String endDtm = getTodayDate()+todoData.getTodoEndDtm();

        todoData.setTodoStartDtm(startDtm);
        todoData.setTodoEndDtm(endDtm);
        todoData.setTodoId(makeTodoId(todoData.getAuthority(),todoData.getTodoTitle()));

        return todoDao.insertTodo(todoData);


    }

    public boolean modifyTodayTodo(TodoData todoData, String todoId){

        String startDtm = getTodayDate()+todoData.getTodoStartDtm();
        String endDtm = getTodayDate()+todoData.getTodoEndDtm();

        todoData.setTodoStartDtm(startDtm);
        todoData.setTodoEndDtm(endDtm);

        return todoDao.modifyTodo(todoData, todoId);

    }

    public boolean deleteTodayTodo(String todoId){

        return todoDao.deleteTodo(todoId);

    }

    //todo : title을 db에 있는 내용과 비교해서 만일 있으면 해당 내용 뒤에 cnt +1 해서 title 구성하기.
    // 예를 들어 오늘의 todo로 제목을 설정해놨는데 있음면 오늘의 todo2(cnt+1)로 자동 설정되도로
    public String makeTodoId(String authority,String title){
        String todoId = "todo"+getTodayDate()+title+authority;
        if(todoId.length()>45){
            todoId = todoId.substring(1,45);
        }
        return todoId;
    }


    public String getTodayDate(){

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return now.format(formatter);

    }

}

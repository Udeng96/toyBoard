package com.example.toyboard.dao.menu.note;

import com.example.toyboard.domain.menu.note.TodoData;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("todoDao")
@Transactional
public class TodoDao {

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(TodoDao.class);

    //insert todoList
    //pagination 필요

    public boolean insertTodo(TodoData todoData){
        boolean result = false;
        try{
            em.persist(todoData);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    //select todoList

    public List<TodoData> selectTodo(String authority,String todayDtm, String todoId){
        List<TodoData> todoDataList = new ArrayList<>();

        try{
            // todo :  substring에 group by가 필수적이었나? 살펴보기

            StringBuffer sb = new StringBuffer();
            sb.append("select t where TodoData t where 1=1 ");
            sb.append("and t.authority = :authority");
            sb.append("and substring(todoStartDtm,1,8) = :todayDtm ");
            //만약 todo의 자세한 내용을 보기 위해 id를 집어넣었을 경우 추가
            if(!todoId.isEmpty()){
                sb.append("and t.todoId = :todoId");
            }
            sb.append("order by substring(todoDtmStartDtm,9,12) asc");
            sb.append("group by t.todoDtmStartDtm");

            Query query = em.createQuery(sb.toString());
            query.setParameter("authority",authority);
            query.setParameter("todayDtm",todayDtm);
            // todo의 자세한 내용을 보기 위해 id값 추가
            if(!todoId.isEmpty()){
                query.setParameter("todoId",todoId);
            }
            todoDataList = query.getResultList();

        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return todoDataList;
    }

    public boolean modifyTodo(TodoData todoData, String todoId){
        boolean result = false;
        try{
            TodoData found = em.find(TodoData.class, todoId);
            //todo : compareAndChangeData
            em.merge(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    public boolean deleteTodo(String todoId){

        boolean result = false;
        try{
            TodoData found = em.find(TodoData.class,todoId);
            em.remove(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

}

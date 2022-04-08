package com.example.toyboard.dao.menu.note;


import com.example.toyboard.domain.menu.note.DiaryData;
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

@Repository("diaryDao")
@Transactional
public class DiaryDao {

    private static final Logger logger = LoggerFactory.getLogger(DiaryDao.class);

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;


    /**
     *
     * @name : insertDiary
     * @author : Jang You Jung
     * @since : 2022-04-08 오전 9:58
     * 오늘의 다이어리 등록
     *
     */

    public boolean insertDiary(DiaryData diaryData){

        boolean result = false;
        try{
            em.persist(diaryData);
            result = true;
        }catch (HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;

    }

    public boolean modifyDiary(DiaryData diaryData,String diaryId){
        boolean result = false;
        try{
            DiaryData found = em.find(DiaryData.class, diaryId);
            //todo : compareAndChangeData
            em.merge(found);
            result = true;

        }catch (HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    public boolean deleteDiary(String diaryId){
        boolean result = false;
        try{
            DiaryData found = em.find(DiaryData.class, diaryId);
            em.remove(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    /**
     *
     * @name : selectDiary
     * @author : Jang You Jung
     * @since : 2022-04-08 오전 10:19
     * 오늘 날짜에 맞는 diary 가져오기
     * authority에 맞는 todayDtm diary를 가져오기
     *
     */

    public List<DiaryData> selectDiary(String authority, String todayDtm){
        List<DiaryData> diaryDaoList = new ArrayList<>();
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select d from DiaryData d where 1=1");
            sb.append(" and d.authority = :authority");
            sb.append(" and d.diaryDtm = :todayDtm");

            Query query = em.createQuery(sb.toString());
            query.setParameter("diartId", authority);
            query.setParameter("todayDtm",todayDtm);
            diaryDaoList = query.getResultList();
        }catch (HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return diaryDaoList;

    }

}

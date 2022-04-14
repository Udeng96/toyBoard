package com.example.toyboard.dao.menu.school;


import com.example.toyboard.domain.menu.school.SchoolData;
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

@Repository("schoolDao")
@Transactional
public class SchoolDao {

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(SchoolDao.class);

    public boolean insertSchoolInfo(SchoolData schoolData){

        boolean result = false;
        try{
            em.persist(schoolData);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    public List<SchoolData> selectSchoolInfo(String userId){

        List<SchoolData> schoolDataList = new ArrayList<>();
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select s from SchoolData s where 1=1 ");
            sb.append("and s.userId = :userId ");

            Query query = em.createQuery(sb.toString());
            query.setParameter("userId",userId);
            schoolDataList = query.getResultList();
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return schoolDataList;
    }

    public boolean modifySchoolInfo(SchoolData schoolData, String userId){
        boolean result = false;
        try{

            SchoolData found = em.find(SchoolData.class, userId);
            found.compareAndChangeData(schoolData);
            em.merge(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    public boolean deleteSchoolInfo(String userId){
        boolean result = false;
        try{
            SchoolData found = em.find(SchoolData.class, userId);
            em.remove(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

}

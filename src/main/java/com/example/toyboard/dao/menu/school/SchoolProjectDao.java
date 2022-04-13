package com.example.toyboard.dao.menu.school;

import com.example.toyboard.domain.menu.school.SchoolProjectData;
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

@Repository("schoolProjectDao")
@Transactional
public class SchoolProjectDao {

    private static final Logger logger = LoggerFactory.getLogger(SchoolProjectDao.class);

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;

    public List<SchoolProjectData> getSchoolProjectList(String userId,String subjectId){

        List<SchoolProjectData> schoolProjectDataList = new ArrayList<>();
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select s from SchoolProjectData s where 1=1 ");
            sb.append("and s.userId = :userId ");
            sb.append("and s.subjectId = :subjectId ");
            sb.append("order by s.sProjectStartDtm");

            Query query = em.createQuery(toString());
            query.setParameter("userId",userId);
            query.setParameter("subjectId",subjectId);
            schoolProjectDataList = query.getResultList();
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return schoolProjectDataList;
    }

    public boolean addSchoolProject(SchoolProjectData schoolProjectData){
        boolean result = false;
        try{
            em.persist(schoolProjectData);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    public boolean modifySchoolProject(SchoolProjectData schoolProjectData, String sProjectId){

        boolean result = false;
        try{
            SchoolProjectData found = em.find(SchoolProjectData.class, sProjectId);
            //todo : compare and change data
            em.merge(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    public boolean deleteSchoolProject(String sProjectId){
        boolean result = false;
        try{
            SchoolProjectData found = em.find(SchoolProjectData.class,sProjectId);
            em.remove(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

}

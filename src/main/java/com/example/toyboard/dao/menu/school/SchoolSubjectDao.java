package com.example.toyboard.dao.menu.school;

import com.example.toyboard.domain.menu.school.SchoolSubjectData;
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

@Repository("schoolSubjectDao")
@Transactional
public class SchoolSubjectDao {

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(SchoolSubjectDao.class);

    public boolean addSubjectInfo(SchoolSubjectData schoolSubjectData){

        boolean result = false;

        try{
            em.persist(schoolSubjectData);
            result = true;
        }catch (HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;

    }

    public List<SchoolSubjectData> getSubjectListByAll(String semester, String userId){
        List<SchoolSubjectData> schoolSubjectDataList = new ArrayList<>();
        String grade = semester.substring(1,1);
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select s from SchoolSubjectData s where 1=1 ");
            sb.append("and userId = :userId ");
            if(!semester.isEmpty()){
                sb.append("and substring(s.subjectSemester,1,1) = :grade ");
            }
            sb.append("order by s.subjectSemester");

            Query query = em.createQuery(sb.toString());
            if(!semester.isEmpty()){
                query.setParameter("grade",grade);
            }
            schoolSubjectDataList = query.getResultList();
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return schoolSubjectDataList;
    }

    public boolean modifySubjectInfo(String subjectId, SchoolSubjectData schoolSubjectData){

        boolean result = false;
        try{

            SchoolSubjectData found = em.find(SchoolSubjectData.class,subjectId);
            //todo : compareAndChangeData
            em.merge(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;

    }

    public boolean deleteSubjectInfo(String subjectId){
        boolean result = false;
        try{
            SchoolSubjectData found = em.find(SchoolSubjectData.class,subjectId);
            em.remove(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

}

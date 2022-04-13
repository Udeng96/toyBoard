package com.example.toyboard.dao.menu.work;

import com.example.toyboard.domain.menu.work.WorkProjectData;
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

@Repository("workProjectDao")
@Transactional
public class WorkProjectDao {

    private static final Logger logger = LoggerFactory.getLogger(WorkProjectDao.class);

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;

    public List<WorkProjectData> getWorkProjectList(String userId, String companyId){

        List<WorkProjectData> workProjectDataList = new ArrayList<>();
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select w from WorkProjectData w where 1=1 ");
            sb.append("and w.userId = :userId ");
            sb.append("and w.companyId = :companyId ");
            sb.append("order by w.wProjectStartDtm");

            Query query = em.createQuery(sb.toString());
            query.setParameter("userId",userId);
            query.setParameter("companyId",companyId);
            workProjectDataList = query.getResultList();
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return workProjectDataList;
    }

    public boolean addWorkProject(WorkProjectData workProjectData){

        boolean result = false;
        try{
            em.persist(workProjectData);
            result =  true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    public boolean modifyWorkProject(WorkProjectData workProjectData, String wProjectId){
        boolean result = false;
        try{
            WorkProjectData found = em.find(WorkProjectData.class, wProjectId);
            //todo : compare and change data
            em.merge(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    public boolean deleteWorkProject(String wProjectId){
        boolean result = false;
        try{
            WorkProjectData found = em.find(WorkProjectData.class,wProjectId);
            em.remove(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

}

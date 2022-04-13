package com.example.toyboard.dao.menu.work;

import com.example.toyboard.domain.menu.work.SelfIntroData;
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

@Repository("selfIntroDao")
@Transactional
public class SelfIntroDao {

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(SelfIntroDao.class);

    public List<SelfIntroData> getIntroList(String userId){
        List<SelfIntroData> selfIntroDataList = new ArrayList<>();

        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select s from SelfIntroData s where 1=1 ");
            sb.append("and s.userId = :userId");

            Query query = em.createQuery(sb.toString());
            query.setParameter("userId",userId);
            selfIntroDataList = query.getResultList();
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }
        return selfIntroDataList;
    }

    public boolean setIntro(SelfIntroData selfIntroData) {

        boolean result = false;

        try {
            em.persist(selfIntroData);
            result = true;
        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean modifyIntro(SelfIntroData selfIntroData, String introId){
        boolean result = false;
        try{
            SelfIntroData found = em.find(SelfIntroData.class,introId);
            found.compareAndChangeData(selfIntroData);
            if(found!=null){
                em.merge(found);
                result = true;
            }else{
                logger.info("NO RESULT");
            }

        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }
        return result;
    }

    public boolean resetIntro(String introId){
        boolean result = false;
        try{
            SelfIntroData found = em.find(SelfIntroData.class, introId);
            if(found!=null){
                em.remove(found);
                result = true;
            }else{
                logger.info("NO RESULT");
            }
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

}

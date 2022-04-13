package com.example.toyboard.dao.menu.work;

import com.example.toyboard.domain.menu.work.CompanyData;
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

@Repository("companyDao")
@Transactional
public class CompanyDao {

    private static final Logger logger = LoggerFactory.getLogger(CompanyDao.class);

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;

    public boolean insertNewCompany(CompanyData companyData){

        boolean result = false;
        try{
            em.persist(companyData);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;

    }

    public List<CompanyData> selectCompanyList(String userId, String companyId){

        List<CompanyData> companyDataList = new ArrayList<>();
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select c from CompanyData c where 1=1 ");
            sb.append("and c.userId = :userId ");
            if(!companyId.isEmpty()){
                sb.append("and c.companyId = :companyId ");
            }
            sb.append("order by c.joinDtm");

            Query query = em.createQuery(sb.toString());
            query.setParameter("userId",userId);
            if(!companyId.isEmpty()){
                query.setParameter("companyId",companyId);
            }
            companyDataList = query.getResultList();
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return companyDataList;
    }

    public boolean modifyCompanyInfo(CompanyData companyData, String companyId){

        boolean result = false;
        try{
            CompanyData found = em.find(CompanyData.class, companyId);
            found.compareAndChangeData(companyData);
            em.merge(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    public boolean deleteCompanyInfo(String companyId){
        boolean result = false;
        try{
            CompanyData found = em.find(CompanyData.class, companyId);
            em.remove(found);
            result = true;
        }catch (HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }


}

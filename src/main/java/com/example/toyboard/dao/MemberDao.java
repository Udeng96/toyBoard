package com.example.toyboard.dao;

import com.example.toyboard.domain.MemberData;
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

@Repository("joinDao")
@Transactional
public class MemberDao {

    private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);

    @PersistenceContext(unitName = "entityManagerFactoryBean")
    EntityManager em;


    /**
     *
     * @name : getMemInfo
     * @author : Jang You Jung
     * @since : 2022-04-08 오전 8:56
     * 현재 페이지에 대한 authority를 가진 사용자 정보 표출
     *
     */

    public List<MemberData> getMemInfo(String pageAuthority){
        List<MemberData> memberDataList = new ArrayList<>();
        try{
            StringBuffer sb = new StringBuffer();
            sb.append("select m from MemberData m where 1=1 ");
            sb.append("and authority = :pageAuthority");
            Query query = em.createQuery(sb.toString());
            query.setParameter("pageAuthority",pageAuthority);
            memberDataList = query.getResultList();


        }catch (HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return memberDataList;
    }


    /**
     *
     * @name : insertMemInfo
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 2:29
     * @return  boolean
     * 회원가입
     *
     */

    public boolean insertMemInfo(MemberData memberData){

        boolean result = false;
        try{
            em.persist(memberData);
            result = true;

        }catch(HibernateException e){
            logger.error(e.getMessage(), e);
        }

        return result;

    }

    /**
     *
     * @name : modifyMemInfo
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 3:47
     * @return  boolean
     * 회원정보 수정 = 이름 / 핸드폰 번호 / 비밀번호 변경
     *
     */

    public boolean modifyMemInfo(MemberData memberData, String email){

        boolean result = false;
        try{
            MemberData found = em.find(MemberData.class,email);
            found.compareAndChangeData(memberData);
            em.merge(found);
            result = true;
        }catch (HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }

    /**
     *
     * @name : deleteMemInfo
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 3:53
     * @return  boolean
     *
     */

    public boolean deleteMemInfo(String email){

        boolean result = false;
        try{
            MemberData found = em.find(MemberData.class, email);
            em.remove(found);
            result = true;
        }catch(HibernateException e){
            logger.error(e.getMessage(),e);
        }

        return result;
    }





}

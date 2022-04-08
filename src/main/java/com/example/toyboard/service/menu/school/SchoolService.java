  package com.example.toyboard.service.menu.school;

import com.example.toyboard.config.ToyBoardConstants;
import com.example.toyboard.dao.menu.school.SchoolDao;
import com.example.toyboard.domain.menu.school.SchoolData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolService.class);

    @Autowired
    SchoolDao schoolDao;

    public List<SchoolData> getSchoolInfo(String userId){

        return schoolDao.selectSchoolInfo(userId);

    }

    public boolean addSchoolInfo(SchoolData schoolData, String lastEdu){

        String setLastEdu = getLastEdu(lastEdu);
        schoolData.setLastEdu(setLastEdu);
        //todo : front 에서 degree 구분해주기

        return schoolDao.insertSchoolInfo(schoolData);

    }

    public boolean modifySchoolInfo(SchoolData schoolData, String lastEdu, String userId){

        String setLastEdu = getLastEdu(lastEdu);
        schoolData.setLastEdu(setLastEdu);
        return schoolDao.modifySchoolInfo(schoolData,userId);

    }

    public boolean deleteSchoolInfo(String userId){

        return schoolDao.deleteSchoolInfo(userId);

    }

    public String getLastEdu(String lastEdu){

        String result = "";
        if(lastEdu.equals(ToyBoardConstants.SCHOOL.HIGH)){
            result = ToyBoardConstants.SCHOOL_DB.HIGH;
        }
        if(lastEdu.equals(ToyBoardConstants.SCHOOL.UNIVERSITY)){
            result = ToyBoardConstants.SCHOOL_DB.UNIVERSITY;
        }
        if(lastEdu.equals(ToyBoardConstants.SCHOOL.GRAD)){
            result = ToyBoardConstants.SCHOOL_DB.GRAD;
        }

        return result;
    }

}

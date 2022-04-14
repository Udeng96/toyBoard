  package com.example.toyboard.service.menu.school;

import com.example.toyboard.config.ToyBoardConstants;
import com.example.toyboard.dao.menu.school.SchoolDao;
import com.example.toyboard.domain.menu.school.SchoolData;
import com.example.toyboard.util.AESCryptoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.List;

@Service
public class SchoolService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolService.class);

    private static final String H = ToyBoardConstants.SCHOOL.HIGH;
    private static final String U = ToyBoardConstants.SCHOOL.UNIVERSITY;
    private static final String G = ToyBoardConstants.SCHOOL.GRAD;

    @Autowired
    SchoolDao schoolDao;

    public List<SchoolData> getSchoolInfo(String userId){

        return schoolDao.selectSchoolInfo(userId);

    }

    public boolean addSchoolInfo(SchoolData schoolData){

        //set LastEdu

        logger.info("lastEdu:{}",schoolData.getLastEdu());

        //set SchoolId
        schoolData.setHighSchoolId(makeSchoolId(H,schoolData.getHighSchoolNm()));
        if(schoolData.getLastEdu().equals(U)){
            schoolData.setUniversityId(makeSchoolId(U,schoolData.getUniversityNm()));
        }
        if(schoolData.getLastEdu().equals(G)){
            schoolData.setUniversityId(makeSchoolId(U,schoolData.getUniversityNm()));
            schoolData.setGradSchoolId(makeSchoolId(G,schoolData.getGradSchoolNm()));
        }
        //todo : front 에서 degree 구분해주기

        String setLastEdu = getLastEdu(schoolData.getLastEdu());
        schoolData.setLastEdu(setLastEdu);

        return schoolDao.insertSchoolInfo(schoolData);

    }

    public boolean modifySchoolInfo(SchoolData schoolData, String userId){



        //set SchoolId
        schoolData.setHighSchoolId(makeSchoolId(H,schoolData.getHighSchoolNm()));
        if(schoolData.getLastEdu().equals(U)){
            schoolData.setUniversityId(makeSchoolId(U,schoolData.getUniversityNm()));;
        }
        if(schoolData.getLastEdu().equals(G)){
            schoolData.setUniversityId(makeSchoolId(U,schoolData.getUniversityNm()));
            schoolData.setGradSchoolId(makeSchoolId(G,schoolData.getGradSchoolNm()));
        }

        String setLastEdu = getLastEdu(schoolData.getLastEdu());
        schoolData.setLastEdu(setLastEdu);

        return schoolDao.modifySchoolInfo(schoolData,userId);

    }

    public boolean deleteSchoolInfo(String userId){

        return schoolDao.deleteSchoolInfo(userId);

    }

    public String getLastEdu(String lastEdu){

        String result = "";
        if(lastEdu.equals(H)){
            result = ToyBoardConstants.SCHOOL_DB.HIGH;
        }
        if(lastEdu.equals(U)){
            result = ToyBoardConstants.SCHOOL_DB.UNIVERSITY;
        }
        if(lastEdu.equals(G)){
            result = ToyBoardConstants.SCHOOL_DB.GRAD;
        }

        return result;
    }

    public String cryptoId(String text){
        SecretKey key = AESCryptoUtil.getKey();
        IvParameterSpec ivParameterSpec = AESCryptoUtil.getIv();
        String specName = "AES/CBC/PKCS5Padding";
        String changeText = "";

        changeText = AESCryptoUtil.encrypt(specName, key, ivParameterSpec, text);
        return changeText;
    }

    public String makeSchoolId(String type, String schoolNm){
        String result = "";
        String id = cryptoId(schoolNm);
        if(type.equals(H)){
            result = "HSchool"+id;
        }
        if(type.equals(U)){
            result = "university"+id;
        }
        if (type.equals(G)) {
            result = "GSchool"+id;
        }

        if(result.length()>45){
            result = result.substring(0,44);
        }

        return result;
    }

}

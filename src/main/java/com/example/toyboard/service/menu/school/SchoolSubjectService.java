package com.example.toyboard.service.menu.school;

import com.example.toyboard.config.ToyBoardConstants;
import com.example.toyboard.dao.menu.school.SchoolSubjectDao;
import com.example.toyboard.domain.menu.school.SchoolSubjectData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolSubjectService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolSubjectService.class);

    @Autowired
    SchoolSubjectDao schoolSubjectDao;

    public List<SchoolSubjectData> getSubjectList(String semester, String userId){

        return schoolSubjectDao.getSubjectListByAll(semester, userId);

    }

    public boolean addSubjectInfo(SchoolSubjectData schoolSubjectData){

        String subjectId = makeSubjectId(schoolSubjectData.getSubjectName(),schoolSubjectData.getAuthority());
        schoolSubjectData.setSubjectId((subjectId));
        schoolSubjectData.setSchoolType(getSubjectType(schoolSubjectData.getSchoolType()));
        return schoolSubjectDao.addSubjectInfo(schoolSubjectData);

    }

    public boolean modifySubjectInfo(String subjectId,SchoolSubjectData schoolSubjectData){

        return schoolSubjectDao.modifySubjectInfo(subjectId,schoolSubjectData);

    }

    public boolean deleteSubjectInfo(String subjectId){

        return schoolSubjectDao.deleteSubjectInfo(subjectId);

    }

    public String makeSubjectId(String subjectNm, String authority){

        authority = authority.substring(14);
        String result =  "sSubject"+subjectNm+authority;
        if(result.length()>45){
            result = result.substring(0,44);
        }

        return result;
    }

    public String getSubjectType(String type){
        String result = "";

        if(type.equals(ToyBoardConstants.SCHOOL.HIGH)){
            result = ToyBoardConstants.SCHOOL_DB.HIGH;
        }
        if(type.equals(ToyBoardConstants.SCHOOL.UNIVERSITY)){
            result = ToyBoardConstants.SCHOOL_DB.UNIVERSITY;
        }
        if(type.equals(ToyBoardConstants.SCHOOL.GRAD)){
            result = ToyBoardConstants.SCHOOL_DB.GRAD;
        }

        return result;
    }

}

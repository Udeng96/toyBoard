package com.example.toyboard.service.menu.school;

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
        schoolSubjectData.setSchoolId(subjectId);
        return schoolSubjectDao.addSubjectInfo(schoolSubjectData);

    }

    public boolean modifySubjectInfo(String subjectId,SchoolSubjectData schoolSubjectData){

        return schoolSubjectDao.modifySubjectInfo(subjectId,schoolSubjectData);

    }

    public boolean deleteSubjectInfo(String subjectId){

        return schoolSubjectDao.deleteSubjectInfo(subjectId);

    }

    public String makeSubjectId(String subjectNm, String authority){

        return "sSubject"+subjectNm+authority;

    }

}

package com.example.toyboard.service.menu.school;

import com.example.toyboard.dao.menu.school.SchoolProjectDao;
import com.example.toyboard.domain.menu.school.SchoolProjectData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolProjectService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolProjectService.class);

    @Autowired
    SchoolProjectDao schoolProjectDao;

    public List<SchoolProjectData> getSchoolProjectDataList(String userId, String subjectId){

        return schoolProjectDao.getSchoolProjectList(userId, subjectId);
    }

    public boolean addSchoolProjectInfo(SchoolProjectData schoolProjectData){

        return schoolProjectDao.addSchoolProject(schoolProjectData);

    }

    public boolean modifySchoolInfo(SchoolProjectData schoolProjectData, String subjectId){

        return schoolProjectDao.modifySchoolProject(schoolProjectData, subjectId);

    }
    public boolean deleteSchoolInfo(String subjectId){

        return schoolProjectDao.deleteSchoolProject(subjectId);

    }

}

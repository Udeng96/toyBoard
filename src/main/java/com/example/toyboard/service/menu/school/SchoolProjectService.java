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

    public List<SchoolProjectData> getSchoolProjectDataList(String userId){

        return schoolProjectDao.getSchoolProjectList(userId);
    }

    public boolean addSchoolProjectInfo(SchoolProjectData schoolProjectData){
        String id = getProjectId(schoolProjectData.getAuthority(),schoolProjectData.getsProjectTitle());
        schoolProjectData.setsProjectId(id);
        return schoolProjectDao.addSchoolProject(schoolProjectData);

    }

    public boolean modifySchoolInfo(SchoolProjectData schoolProjectData, String subjectId){

        return schoolProjectDao.modifySchoolProject(schoolProjectData, subjectId);

    }
    public boolean deleteSchoolInfo(String subjectId){

        return schoolProjectDao.deleteSchoolProject(subjectId);

    }

    public String getProjectId(String authority,String projectNm){

        authority = authority.substring(14);
        String result = "sProject_"+projectNm+authority;

        if(result.length()>45){
            result = result.substring(0,44);
        }

        return result;

    }

}

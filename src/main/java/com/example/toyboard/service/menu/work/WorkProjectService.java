package com.example.toyboard.service.menu.work;

import com.example.toyboard.dao.menu.work.WorkProjectDao;
import com.example.toyboard.domain.menu.work.WorkProjectData;
import com.example.toyboard.util.AESCryptoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkProjectService {

    private static final Logger logger = LoggerFactory.getLogger(WorkProjectService.class);

    @Autowired
    WorkProjectDao workProjectDao;

    public List<WorkProjectData> getWorkProjectList(String userId,String companyId){

        return workProjectDao.getWorkProjectList(userId, companyId);

    }

    public boolean addWorkProject(WorkProjectData workProjectData){

        String id = makeWorkProjectId(workProjectData.getCompanyId(),workProjectData.getwProjectTitle());
        workProjectData.setwProjectId(id);
        return workProjectDao.addWorkProject(workProjectData);
    }

    public boolean modifyWorkProject(WorkProjectData workProjectData, String wProjectId){

        return workProjectDao.modifyWorkProject(workProjectData, wProjectId);

    }

    public boolean deleteWorkProject(String wProjectId){

        return workProjectDao.deleteWorkProject(wProjectId);

    }

    public String makeWorkProjectId(String companyId, String title){

        companyId = companyId.substring(10,companyId.length());
        title = title.replaceAll(" ","");
        String id = "wProject"+companyId+title;
        if(id.length()>45){
            id = id.substring(1,45);
        }
        return id;
    }

}

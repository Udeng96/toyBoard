package com.example.toyboard.controller.menu.work;

import com.example.toyboard.domain.menu.work.WorkProjectData;
import com.example.toyboard.service.menu.work.WorkProjectService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/work")
public class WorkProjectController {

    private static final Logger logger = LoggerFactory.getLogger(WorkProjectController.class);
    Gson gson = new Gson();

    @Autowired
    WorkProjectService workProjectService;

    @GetMapping(value = "/project/list")
    public String getWorkProjectList(
            @RequestParam(value = "userId",defaultValue = "")String userId,
            @RequestParam(value = "companyId",defaultValue = "")String companyId
    ){
        List<WorkProjectData> list =  workProjectService.getWorkProjectList(userId,companyId);
        return gson.toJson(list);
    }

    @PostMapping(value = "/project/add")
    public boolean addWorkProject(
            @RequestBody WorkProjectData workProjectData
    ){
        return workProjectService.addWorkProject(workProjectData);
    }

    @PostMapping(value = "/project/modify")
    public boolean modifyWorkProject(
            @RequestBody WorkProjectData workProjectData,
            @RequestParam(value = "wProjectId", defaultValue = "")String wProjectId
    ){
        return workProjectService.modifyWorkProject(workProjectData, wProjectId);
    }

    @PostMapping(value = "/project/delete")
    public boolean deleteWorkProject(
            @RequestParam(value = "wProjectId")String wProjectId
    ){
        return workProjectService.deleteWorkProject(wProjectId);
    }


}

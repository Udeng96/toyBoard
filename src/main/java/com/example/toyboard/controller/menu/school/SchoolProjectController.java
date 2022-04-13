package com.example.toyboard.controller.menu.school;

import com.example.toyboard.domain.menu.school.SchoolProjectData;
import com.example.toyboard.service.menu.school.SchoolProjectService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/school",produces = "application/json; charset=utf-8")
public class SchoolProjectController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolProjectController.class);
    Gson gson = new Gson();
    @Autowired
    SchoolProjectService schoolProjectService;

    @GetMapping("/project/list")
    public String getProjectList(
            @RequestParam(value = "userId",defaultValue = "")String userId,
            @RequestParam(value = "subjectId",defaultValue = "")String subjectId
    ){

        List<SchoolProjectData> list = schoolProjectService.getSchoolProjectDataList(userId, subjectId);
        return gson.toJson(list);
    }

    @PostMapping("/project/add")
    public boolean addProjectInfo(
            @RequestBody SchoolProjectData schoolProjectData
    ){
        return schoolProjectService.addSchoolProjectInfo(schoolProjectData);
    }

    @PostMapping("/project/modify")
    public boolean modifyProjectInfo(
            @RequestBody SchoolProjectData schoolProjectData,
            @RequestParam(value = "subjectId",defaultValue = "")String subjectId
    ){
        return schoolProjectService.modifySchoolInfo(schoolProjectData, subjectId);
    }

    @PostMapping("/project/delete")
    public boolean deleteProjectInfo(
          @RequestParam(value = "subjectId",defaultValue = "")String subjectId
    ){
        return schoolProjectService.deleteSchoolInfo(subjectId);
    }

}

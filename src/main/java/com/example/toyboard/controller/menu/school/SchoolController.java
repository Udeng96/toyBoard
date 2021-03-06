package com.example.toyboard.controller.menu.school;

import com.example.toyboard.domain.menu.school.SchoolData;
import com.example.toyboard.service.menu.school.SchoolService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/school", produces = "application/json; charset=utf8")
public class SchoolController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolController.class);
    Gson gson = new Gson();

    @Autowired
    SchoolService schoolService;

    @GetMapping("/edu/info")
    public String getSchoolInfo(
            @RequestParam(value = "userId", defaultValue = "")String userId
    ){
        List<SchoolData> list = schoolService.getSchoolInfo(userId);
        return gson.toJson(list);
    }

    @PostMapping("/edu/add")
    public boolean addSchoolInfo(
            @RequestBody SchoolData schoolData
    ){
        return schoolService.addSchoolInfo(schoolData);
    }

    @PostMapping("/edu/modify")
    public boolean modifySchoolInfo(
            @RequestBody SchoolData schoolData,
            @RequestParam(value = "userId", defaultValue = "")String userId
    ){
        return schoolService.modifySchoolInfo(schoolData, userId);
    }

    @PostMapping("/edu/delete")
    public boolean deleteSchoolInfo(
            @RequestParam(value = "userId",defaultValue = "")String userId
    ){
        return schoolService.deleteSchoolInfo(userId);
    }


}

package com.example.toyboard.controller.menu.school;

import com.example.toyboard.domain.menu.school.SchoolSubjectData;
import com.example.toyboard.service.menu.school.SchoolSubjectService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/school", produces = "application/json; charset=utf-8")
public class SchoolSubjectController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolSubjectController.class);
    Gson gson = new Gson();

    @Autowired
    SchoolSubjectService schoolSubjectService;

    @GetMapping(value = "/subject/list")
    public String getSubjectInfo(
            @RequestParam(value = "semester",defaultValue = "")String semester,
            @RequestParam(value = "userId",defaultValue = "")String userId
    ){
        List<SchoolSubjectData> list = schoolSubjectService.getSubjectList(semester, userId);
        return gson.toJson(list);
    }

    @PostMapping(value = "/subject/add")
    public boolean addSubjectInfo(
            @RequestBody SchoolSubjectData schoolSubjectData
    ){
        return schoolSubjectService.addSubjectInfo(schoolSubjectData);
    }

    @PostMapping(value = "/subject/modify")
    public boolean modifySubjectInfo(
            @RequestBody SchoolSubjectData schoolSubjectData,
            @RequestParam(value = "subjectId",defaultValue = "")String subjectId
    ){
        return schoolSubjectService.modifySubjectInfo(subjectId, schoolSubjectData);
    }

    @PostMapping(value = "/subject/delete")
    public boolean deleteSubjectInfo(
            @RequestParam(value = "subjectId", defaultValue = "")String subjectId
    ){
        return schoolSubjectService.deleteSubjectInfo(subjectId);
    }


}

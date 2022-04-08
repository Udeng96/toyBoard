package com.example.toyboard.controller.menu.note;

import com.example.toyboard.domain.menu.note.DiaryData;
import com.example.toyboard.service.menu.note.DiaryService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/diary")
public class DiaryController {

    private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);
    Gson gson = new Gson();

    @Autowired
    DiaryService diaryService;

    @GetMapping(value = "/list")
    public String getDiaryList(
            @RequestParam(value = "authority", defaultValue = "")String authority
    ){
        List<DiaryData> list = diaryService.getTodayDiary(authority);
        return gson.toJson(list);
    }

    @PostMapping(value = "/add")
    public boolean addTodayDiary(
            @RequestBody DiaryData diaryData
    ){
        return diaryService.addTodayDiary(diaryData);
    }

    @PostMapping(value = "/modify")
    public boolean modifyTodayDiary(
            @RequestBody DiaryData diaryData,
            @RequestParam(value = "diaryId",defaultValue = "")String diaryId
    ){
        return diaryService.modifyTodayDiary(diaryData, diaryId);
    }

    @PostMapping("/delete")
    public boolean deleteTodayDiary(
            @RequestParam(value = "diaryId",defaultValue = "")String diaryId
    ){
        return diaryService.deleteTodayDiary(diaryId);
    }
}

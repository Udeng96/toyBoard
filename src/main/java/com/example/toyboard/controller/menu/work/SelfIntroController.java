package com.example.toyboard.controller.menu.work;

import com.example.toyboard.domain.menu.work.SelfIntroData;
import com.example.toyboard.service.menu.work.SelfIntroService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/selfIntro")
public class SelfIntroController {

    private static final Logger logger = LoggerFactory.getLogger(SelfIntroController.class);
    Gson gson = new Gson();

    @Autowired
    SelfIntroService selfIntroService;

    @GetMapping("/read")
    public String getIntroInfo(
            @RequestParam(value = "user_id", defaultValue = "")String userId
    ){
        List<SelfIntroData> list = selfIntroService.getIntroInfo(userId);
        return gson.toJson(list);

    }

    @PostMapping("/set")
    public boolean setIntroInfo(
            @RequestBody SelfIntroData selfIntroData
    ){
        return selfIntroService.setIntro(selfIntroData);
    }

    @PostMapping("/modify")
    public boolean modifyIntroInfo(
            @RequestBody SelfIntroData selfIntroData,
            @RequestParam String introId
    ){
        return selfIntroService.modifyIntro(selfIntroData, introId);
    }

    @PostMapping("/delete")
    public boolean resetIntroInfo(
            @RequestParam String introId
    ){
        return selfIntroService.resetIntro(introId);
    }

}

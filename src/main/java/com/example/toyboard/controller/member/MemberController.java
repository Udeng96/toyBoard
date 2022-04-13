package com.example.toyboard.controller.member;

import com.example.toyboard.domain.MemberData;
import com.example.toyboard.service.MemberService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    Gson gson = new Gson();

    @Autowired
    MemberService memberService;


    @GetMapping(value = "/info")
    public String getMemInfo(
            @RequestParam(value = "pageAuthority",defaultValue = "")String pageAuthority
    ){
        List<MemberData> list = memberService.getMemInfo(pageAuthority);
        return gson.toJson(list);
    }

    @PostMapping(value = "/join")
    public boolean insertMemInfo(
            @RequestBody MemberData memberData
    ){
        return memberService.addMemInfo(memberData);
    }

    @PostMapping(value = "/info/modify")
    public boolean modifyMemInfo(
            @RequestBody MemberData memberData,
            @RequestParam(value = "id",defaultValue = "")String id
    ){
        return memberService.modifyMemInfo(memberData, id);
    }

    @PostMapping(value = "/info/delete")
    public boolean deleteMemInfo(
            @RequestParam(value = "id",defaultValue = "")String id
    ){
        return memberService.deleteMemInfo(id);
    }




}

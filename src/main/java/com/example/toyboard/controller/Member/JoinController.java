package com.example.toyboard.controller.Member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/join")
public class JoinController {

    private static final Logger logger = LoggerFactory.getLogger(JoinController.class);

    @PostMapping()
    public Boolean insertMemInfo(
    ){
        return false;
    }


}

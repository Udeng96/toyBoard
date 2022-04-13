package com.example.toyboard.service.menu.work;

import com.example.toyboard.dao.menu.work.SelfIntroDao;
import com.example.toyboard.domain.menu.work.SelfIntroData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SelfIntroService {

    private static final Logger logger = LoggerFactory.getLogger(SelfIntroService.class);

    @Autowired
    SelfIntroDao selfIntroDao;

    public List<SelfIntroData> getIntroInfo(String userId){

        return selfIntroDao.getIntroList(userId);

    }

    public boolean setIntro(SelfIntroData selfIntroData){

        String introId = makeIntroId(selfIntroData.getAuthority());
        String date = getDateTime();

        selfIntroData.setIntroId(introId);
        selfIntroData.setRegDtm(date);

        return selfIntroDao.setIntro(selfIntroData);

    }

    public boolean modifyIntro(SelfIntroData selfIntroData, String introId){

        String date = getDateTime();
        selfIntroData.setRegDtm(date);

        return selfIntroDao.modifyIntro(selfIntroData, introId);

    }

    public boolean resetIntro(String introId){

        return selfIntroDao.resetIntro(introId);

    }

    public String makeIntroId(String authority){
        authority = authority.substring(15,authority.length());
        String result = "introId"+authority;

        if(result.length()>45){
            result = result.substring(1,45);
        }

        return result;
    }

    public String getDateTime(){

        LocalDate now = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmm");
        String date = now.format(formatter);
        String time = nowTime.format(timeFormatter);
        return date+time;

    }

}

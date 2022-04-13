package com.example.toyboard.service.menu.note;

import com.example.toyboard.dao.menu.note.DiaryDao;
import com.example.toyboard.domain.menu.note.DiaryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DiaryService {

    private static final Logger logger = LoggerFactory.getLogger(DiaryService.class);

    @Autowired
    DiaryDao diaryDao;

    public List<DiaryData> getTodayDiary(String authority){


        String todayDtm = getTodayDate();

        return diaryDao.selectDiary(authority, todayDtm);

    }

    public boolean addTodayDiary(DiaryData diaryData){

        //authority는 프론트엔드에서 member의 authority를 받아와 저장

        String diaryId = makeDiaryId(diaryData.getAuthority());
        diaryData.setDiaryId(diaryId);
        return diaryDao.insertDiary(diaryData);

    }

    public boolean modifyTodayDiary(DiaryData diaryData, String diaryId){

        return diaryDao.modifyDiary(diaryData, diaryId);

    }

    public boolean deleteTodayDiary(String diaryId){

        return diaryDao.deleteDiary(diaryId);

    }

    /**
     *
     * @name : makeDiaryId
     * @author : Jang You Jung
     * @since : 2022-04-08 오전 10:49
     * diary의 ID를 생성하는 메서드
     *
     */

    public String makeDiaryId(String authority){

        authority = authority.substring(15,authority.length());
        String diaryId = "diary"+getTodayDate()+authority;
        if(diaryId.length()>45){
            diaryId = diaryId.substring(1,45);
        }
        return diaryId;
    }

    /**
     *
     * @name : getTodayDate
     * @author : Jang You Jung
     * @since : 2022-04-08 오전 10:48
     * 오늘 날짜를 가져오는 메서드
     *
     */

    public String getTodayDate(){

        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");;
        return now.format(formatter);

    }

}

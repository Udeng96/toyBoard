package com.example.toyboard.service;


import com.example.toyboard.dao.MemberDao;
import com.example.toyboard.domain.MemberData;
import com.example.toyboard.util.AESCryptoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.List;

@Service
public class MemberService {

    private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    MemberDao memberDao;


    /**
     *
     * @name : getMemInfo
     * @author : Jang You Jung
     * @since : 2022-04-08 오전 9:07
     * 현재 페이지에 대한 authority를 가진 사용자 정보 표출
     *
     */
    public List<MemberData> getMemInfo(String pageAuthority){

        return memberDao.getMemInfo(pageAuthority);

    }


    /**
     *
     * @name : addMemInfo
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 4:33
     * @return  boolean
     * 회원가입 회원정보 추가
     * pwd는 암호화를 진행한 뒤 저장
     *
     */

    public boolean addMemInfo(MemberData memberData){

        String pwd = memberData.getPwd();
        String encryptPwd = cryptoText(pwd,"encrypt");
        String authority = makeAuthority(memberData.getId());

        memberData.setPwd(encryptPwd);
        memberData.setAuthority(authority);

        return memberDao.insertMemInfo(memberData);
    }

    /**
     *
     * @name : modifyMemInfo
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 4:35
     * @return  boolean
     * 회원정보 수정
     *
     */

    public boolean modifyMemInfo(MemberData memberData, String id){

        String pwd = memberData.getPwd();
        String encryptPwd = cryptoText(pwd,"encrypt");
        return memberDao.modifyMemInfo(memberData, id);

    }

    /**
     *
     * @name : deleteMemInfo
     * @author : user
     * @since : 2022-04-07 오후 4:34
     * @return  boolean
     * 회원 정보 삭제
     *
     */

    public boolean deleteMemInfo(String id){

        return memberDao.deleteMemInfo(id);

    }


    /**
     *
     * @name : cryptoText
     * @author : Jang You Jung
     * @since : 2022-04-07 오후 4:28
     * @return  java.lang.String
     * 패스워드 암호화, 복호화
     *
     */

    public String cryptoText(String text, String type){
        SecretKey key = AESCryptoUtil.getKey();
        IvParameterSpec ivParameterSpec = AESCryptoUtil.getIv();
        String specName = "AES/CBC/PKCS5Padding";
        String changeText = "";

        //cipherText
        if(type.equals("encrypt")){
            changeText = AESCryptoUtil.encrypt(specName, key, ivParameterSpec, text);
        //plainText
        }else{
            changeText = AESCryptoUtil.decrypt(specName,key,ivParameterSpec,text);
        }

        return changeText;
    }

    public String makeAuthority(String id){
        String encryptId = cryptoText(id,"encrypt");
        String authority = "pageAuthority_"+encryptId;

        return authority;
    }
}

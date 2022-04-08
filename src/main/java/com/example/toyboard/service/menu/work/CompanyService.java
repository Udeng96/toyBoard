package com.example.toyboard.service.menu.work;

import com.example.toyboard.dao.menu.work.CompanyDao;
import com.example.toyboard.domain.menu.work.CompanyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    CompanyDao companyDao;

    public List<CompanyData> getCompanyList(String userId, String companyId){

        return companyDao.selectCompanyList(userId,companyId);

    }

    public boolean addCompany(CompanyData companyData){

        String companyId = makeCompanyId(companyData.getUserId(),companyData.getCompanyNm(),companyData.getJoinDtm());
        companyData.setCompanyId(companyId);
        return companyDao.insertNewCompany(companyData);

    }

    public boolean modifyCompanyInfo(CompanyData companyData, String companyId){

        return companyDao.modifyCompanyInfo(companyData, companyId);

    }

    public boolean deleteCompanyInfo(String companyId){

        return companyDao.deleteCompanyInfo(companyId);

    }

    public String makeCompanyId(String userId, String companyNm, String joinDtm){

        joinDtm = joinDtm.substring(1,6);
        String result = "companyId"+userId+joinDtm+companyNm;

        return result;
    }

}

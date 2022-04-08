package com.example.toyboard.controller.menu.work;

import com.example.toyboard.domain.menu.work.CompanyData;
import com.example.toyboard.service.menu.work.CompanyService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    Gson gson = new Gson();

    @Autowired
    CompanyService companyService;

    @GetMapping("/company/list")
    public String getCompanyList(
            @RequestParam(value="userId", defaultValue = "")String userId,
            @RequestParam(value = "companyId",required = false,defaultValue = "")String companyID
    ){

        List<CompanyData> list = companyService.getCompanyList(userId,companyID);
        return gson.toJson(list);

    }

    @PostMapping("/company/add")
    public boolean addCompany(
            @RequestBody CompanyData companyData
    ){
        return companyService.addCompany(companyData);
    }

    @PostMapping("/company/modify")
    public boolean modifyCompanyInfo(
            @RequestBody CompanyData companyData,
            @RequestParam(value = "companyId",defaultValue = "")String companyId
    ){

        return companyService.modifyCompanyInfo(companyData, companyId);

    }

    @PostMapping("/company/delete")
    public boolean deleteCompanyInfo(
            @RequestParam(value="companyId",defaultValue = "")String companyId
    ){
        return companyService.deleteCompanyInfo(companyId);
    }

}

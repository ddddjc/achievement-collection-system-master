package com.emc.achievement.service;

import com.emc.achievement.entity.ResearchReport;
import com.emc.achievement.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ResearchReportService {


    ResponseResult insertSelective(ResearchReport record);

    ResponseResult updateByPrimaryKeySelective(ResearchReport record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}


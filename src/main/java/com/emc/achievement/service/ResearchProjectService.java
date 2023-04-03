package com.emc.achievement.service;

import com.emc.achievement.entity.ResearchProject;
import com.emc.achievement.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ResearchProjectService {


    ResponseResult insertSelective(ResearchProject record);

    ResponseResult updateByPrimaryKeySelective(ResearchProject record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}


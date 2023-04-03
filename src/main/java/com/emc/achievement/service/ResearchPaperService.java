package com.emc.achievement.service;

import com.emc.achievement.entity.ResearchPaper;
import com.emc.achievement.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ResearchPaperService {


    ResponseResult insertSelective(ResearchPaper record);

    ResponseResult updateByPrimaryKeySelective(ResearchPaper record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}




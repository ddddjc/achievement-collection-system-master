package com.emc.achievement.service;

import com.emc.achievement.entity.ResearchTextbook;
import com.emc.achievement.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ResearchTextbookService {


    ResponseResult insertSelective(ResearchTextbook record);

    ResponseResult updateByPrimaryKeySelective(ResearchTextbook record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}



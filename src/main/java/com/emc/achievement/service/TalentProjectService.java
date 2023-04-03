package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentProject;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface TalentProjectService {

    ResponseResult insertSelective(TalentProject record);

    ResponseResult updateByPrimaryKeySelective(TalentProject record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}


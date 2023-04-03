package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.ServiceJudgment;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ServiceJudgmentService {

    ResponseResult insertSelective(ServiceJudgment record);

    ResponseResult updateByPrimaryKeySelective(ServiceJudgment record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}


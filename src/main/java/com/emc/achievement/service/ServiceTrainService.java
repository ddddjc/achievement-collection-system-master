package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.ServiceTrain;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ServiceTrainService {

    ResponseResult insertSelective(ServiceTrain record);

    ResponseResult updateByPrimaryKeySelective(ServiceTrain record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}


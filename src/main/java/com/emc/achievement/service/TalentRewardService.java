package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentReward;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface TalentRewardService {


    ResponseResult insertSelective(TalentReward record);

    ResponseResult updateByPrimaryKeySelective(TalentReward record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}


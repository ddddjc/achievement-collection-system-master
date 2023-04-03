package com.emc.achievement.service;

import com.emc.achievement.entity.ResearchReward;
import com.emc.achievement.entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;import java.util.List;

public interface ResearchRewardService {


    ResponseResult insertSelective(ResearchReward record);

    ResponseResult updateByPrimaryKeySelective(ResearchReward record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}



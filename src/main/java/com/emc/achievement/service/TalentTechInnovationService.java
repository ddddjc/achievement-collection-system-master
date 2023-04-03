package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentTechInnovation;
public interface TalentTechInnovationService{


    ResponseResult insertSelective(TalentTechInnovation record);

    ResponseResult updateByPrimaryKeySelective(TalentTechInnovation record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}

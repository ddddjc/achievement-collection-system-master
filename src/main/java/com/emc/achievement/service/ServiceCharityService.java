package com.emc.achievement.service;

import java.util.List;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.ServiceCharity;
import com.emc.achievement.entity.TalentSubjectCompetition;

public interface ServiceCharityService{


    ResponseResult insertSelective(ServiceCharity record);

    ResponseResult updateByPrimaryKeySelective(ServiceCharity record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);


}

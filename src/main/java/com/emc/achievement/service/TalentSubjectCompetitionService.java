package com.emc.achievement.service;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentSubjectCompetition;
public interface TalentSubjectCompetitionService{


    ResponseResult insertSelective(TalentSubjectCompetition record);

    ResponseResult updateByPrimaryKeySelective(TalentSubjectCompetition record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}

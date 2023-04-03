package com.emc.achievement.service;

import java.util.List;

import com.emc.achievement.entity.ResponseResult;
import com.emc.achievement.entity.TalentSubjectCompetition;
import com.emc.achievement.entity.TalentTeachMeeting;
public interface TalentTeachMeetingService{


    ResponseResult insertSelective(TalentTeachMeeting record);

    ResponseResult updateByPrimaryKeySelective(TalentTeachMeeting record);

    ResponseResult findByUsername(String username);

    ResponseResult findByRecordId(Long recordId);

    ResponseResult find();

    ResponseResult deleteById(Long Id);

}

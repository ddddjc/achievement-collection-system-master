package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentTeachMeeting;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentTeachMeetingMapper {
    int insertSelective(TalentTeachMeeting record);

    int updateByPrimaryKeySelective(TalentTeachMeeting record);

    List<TalentTeachMeeting> find();

    TalentTeachMeeting findById(@Param("id") Long id);

    List<TalentTeachMeeting> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
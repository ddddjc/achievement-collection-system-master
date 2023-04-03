package com.emc.achievement.mapper;

import com.emc.achievement.entity.ResearchMeeting;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResearchMeetingMapper {
    int insertSelective(ResearchMeeting record);

    int updateByPrimaryKeySelective(ResearchMeeting record);

    List<ResearchMeeting> find();

    List<ResearchMeeting> findByUsername(@Param("username") String username);

    ResearchMeeting findById(@Param("id") Long id);

    int deleteById(@Param("id") Long id);
}
package com.emc.achievement.mapper;

import com.emc.achievement.entity.ResearchReward;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResearchRewardMapper {
    int insertSelective(ResearchReward record);

    int updateByPrimaryKeySelective(ResearchReward record);

    List<ResearchReward> find();

    ResearchReward findById(@Param("id") Long id);

    List<ResearchReward> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
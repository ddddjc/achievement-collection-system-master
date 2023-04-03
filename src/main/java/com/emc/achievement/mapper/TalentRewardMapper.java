package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentReward;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentRewardMapper {
    int insertSelective(TalentReward record);

    int updateByPrimaryKeySelective(TalentReward record);

    List<TalentReward> find();

    TalentReward findById(@Param("id") Long id);

    List<TalentReward> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
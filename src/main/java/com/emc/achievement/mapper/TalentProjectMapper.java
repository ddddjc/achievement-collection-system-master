package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentProject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentProjectMapper {
    int insertSelective(TalentProject record);

    int updateByPrimaryKeySelective(TalentProject record);

    List<TalentProject> find();

    TalentProject findById(@Param("id") Long id);

    List<TalentProject> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
package com.emc.achievement.mapper;

import com.emc.achievement.entity.ResearchProject;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResearchProjectMapper {
    int insertSelective(ResearchProject record);

    int updateByPrimaryKeySelective(ResearchProject record);

    List<ResearchProject> find();

    ResearchProject findById(@Param("id") Long id);

    List<ResearchProject> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
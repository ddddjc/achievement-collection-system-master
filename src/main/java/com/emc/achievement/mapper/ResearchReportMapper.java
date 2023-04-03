package com.emc.achievement.mapper;

import com.emc.achievement.entity.ResearchReport;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResearchReportMapper {
    int insertSelective(ResearchReport record);

    int updateByPrimaryKeySelective(ResearchReport record);

    List<ResearchReport> find();

    ResearchReport findById(@Param("id") Long id);

    List<ResearchReport> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
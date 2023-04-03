package com.emc.achievement.mapper;

import com.emc.achievement.entity.ResearchPaper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResearchPaperMapper {
    int insertSelective(ResearchPaper record);

    int updateByPrimaryKeySelective(ResearchPaper record);

    List<ResearchPaper> find();

    List<ResearchPaper> findByUsername(@Param("username") String username);

    ResearchPaper findById(@Param("id") Long id);

    int deleteById(@Param("id") Long id);
}
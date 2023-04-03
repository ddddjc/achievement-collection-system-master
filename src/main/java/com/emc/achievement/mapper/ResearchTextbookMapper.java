package com.emc.achievement.mapper;

import com.emc.achievement.entity.ResearchTextbook;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResearchTextbookMapper {
    int insertSelective(ResearchTextbook record);

    int updateByPrimaryKeySelective(ResearchTextbook record);

    List<ResearchTextbook> find();

    ResearchTextbook findById(@Param("id") Long id);

    List<ResearchTextbook> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
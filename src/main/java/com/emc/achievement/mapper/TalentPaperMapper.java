package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentPaper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentPaperMapper {
    int insertSelective(TalentPaper record);

    int updateByPrimaryKeySelective(TalentPaper record);

    List<TalentPaper> find();

    TalentPaper findById(@Param("id") Long id);

    List<TalentPaper> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
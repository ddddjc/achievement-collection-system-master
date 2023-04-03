package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentSubjectCompetition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentSubjectCompetitionMapper {
    int insertSelective(TalentSubjectCompetition record);

    int updateByPrimaryKeySelective(TalentSubjectCompetition record);

    List<TalentSubjectCompetition> find();

    TalentSubjectCompetition findById(@Param("id") Long id);

    List<TalentSubjectCompetition> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentTechInnovation;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentTechInnovationMapper {
    int insertSelective(TalentTechInnovation record);

    int updateByPrimaryKeySelective(TalentTechInnovation record);

    List<TalentTechInnovation> find();

    TalentTechInnovation findById(@Param("id") Long id);

    List<TalentTechInnovation> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
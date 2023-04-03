package com.emc.achievement.mapper;

import com.emc.achievement.entity.TalentTextbook;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TalentTextbookMapper {
    int insertSelective(TalentTextbook record);

    int updateByPrimaryKeySelective(TalentTextbook record);

    List<TalentTextbook> find();

    TalentTextbook findById(@Param("id") Long id);

    List<TalentTextbook> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
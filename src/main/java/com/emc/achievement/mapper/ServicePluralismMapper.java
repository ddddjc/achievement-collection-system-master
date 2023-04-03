package com.emc.achievement.mapper;

import com.emc.achievement.entity.ServicePluralism;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServicePluralismMapper {
    int insertSelective(ServicePluralism record);

    int updateByPrimaryKeySelective(ServicePluralism record);

    List<ServicePluralism> find();

    ServicePluralism findById(@Param("id") Long id);

    List<ServicePluralism> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
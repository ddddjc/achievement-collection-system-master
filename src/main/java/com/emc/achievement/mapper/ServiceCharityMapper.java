package com.emc.achievement.mapper;

import com.emc.achievement.entity.ServiceCharity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceCharityMapper {
    int insertSelective(ServiceCharity record);

    int updateByPrimaryKeySelective(ServiceCharity record);

    List<ServiceCharity> find();

    List<ServiceCharity> findByUsername(@Param("username") String username);

    ServiceCharity findById(@Param("id") Long id);

    int deleteById(@Param("id") Long id);
}
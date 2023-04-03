package com.emc.achievement.mapper;

import com.emc.achievement.entity.ServiceEditor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceEditorMapper {
    int insertSelective(ServiceEditor record);

    int updateByPrimaryKeySelective(ServiceEditor record);

    List<ServiceEditor> find();

    ServiceEditor findById(@Param("id") Long id);

    List<ServiceEditor> findByUsername(@Param("username") String username);

    int deleteById(@Param("id") Long id);
}
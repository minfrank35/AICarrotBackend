package com.labscale.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationDAO {
    @Select("SELECT local_name FROM locations WHERE latitude != #{latitude} AND longitude != #{longitude}")
    List<String> findLocalNamesByCoordinates(@Param("latitude") double latitude, @Param("longitude") double longitude);
}
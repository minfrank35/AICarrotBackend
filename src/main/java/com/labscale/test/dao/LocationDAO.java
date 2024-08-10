package com.labscale.test.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationDAO {
    @Select("""
    SELECT CONCAT_WS(' ', sido, si_gun_gu, dong) AS full_address
    FROM location
    WHERE (
        6371 * acos(
            cos(radians(#{latitude})) * cos(radians(latitude)) * cos(radians(longitude) - radians(#{longitude}))
            + sin(radians(#{latitude})) * sin(radians(latitude))
        )
    ) <= 5
    """)
    List<String> findLocalNamesByCoordinates(@Param("latitude") double latitude, @Param("longitude") double longitude);
}
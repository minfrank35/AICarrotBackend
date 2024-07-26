package com.labscale.test.dto.req;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// 위치 찾기 API 요청 DTO
public class LocationReqDTO {
    private double latitude;
    private double longitude;
    private String apiSecretKey;

    // 생성자, getter, setter 생략
}
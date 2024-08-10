package com.labscale.test.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 공통 응답 DTO
public class ApiResponse<T> {
    private String apiSvcId;
    private String resultCode;
    private String resultMessage;
    private T resData;

    // 생성자, getter, setter 생략
}
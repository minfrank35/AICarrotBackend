package com.labscale.test.dto.req;

import lombok.Data;

@Data
public class LoginReqDTO {
    private String name;
    private String phoneNumber;
    private String apiSecretKey;
}
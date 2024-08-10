package com.labscale.test.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APIRequest<T> {
    private String apiSecretKey;
    private T data;
}
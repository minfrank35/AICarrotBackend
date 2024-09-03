package com.labscale.test.controller;

import com.labscale.test.dto.req.APIRequest;
import com.labscale.test.dto.req.LoginReqDTO;
import com.labscale.test.dto.res.ApiResponse;
import com.labscale.test.dto.res.LoginResDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public ApiResponse<LoginResDTO> login(@RequestBody APIRequest<LoginReqDTO> req) {
        // 요청에서 data 필드를 추출하여 전화번호와 API 시크릿 키 가져옴
        LoginReqDTO loginData = req.getData();
        String phoneNumber = loginData.getPhoneNumber();
        String apiSecretKey = loginData.getApiSecretKey();

        // 응답을 생성하기 위한 변수
        ApiResponse<LoginResDTO> response = new ApiResponse<>();
        LoginResDTO resData = new LoginResDTO();

//        // 여기에 실제 인증 로직을 추가 (예: 전화번호 인증번호 전송 로직)
//        if (sendVerificationCode(phoneNumber, apiSecretKey)) {
//            // 성공적으로 인증번호 전송
//            resData.setResultCode("0000");
//            resData.setResultMessage("인증번호가 전송되었습니다.");
//        } else {
//            // 인증 실패 처리
//            resData.setResultCode("9999");
//            resData.setResultMessage("인증번호 전송 실패.");
//        }

        // 응답 객체 설정
        response.setApiSvcId("CM01");
        response.setResultCode("200");
        response.setResultMessage("성공적으로 호출되었습니다.");
        response.setResData(resData);

        return response;
    }
}

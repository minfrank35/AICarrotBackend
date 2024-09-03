//package com.labscale.test.service;
//
//import com.labscale.test.dto.req.APIRequest;
//import com.labscale.test.dto.req.LoginReqDTO;
//import com.labscale.test.dto.res.ApiResponse;
//import com.labscale.test.dto.res.LocationResDTO;
//import com.labscale.test.dto.res.LoginResDTO;
//import com.labscale.test.repository.LocationRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//    private final
//
//    public ApiResponse<LoginResDTO> sendSmsToFindEmail(APIRequest<LoginReqDTO> requestDto) {
//        String name = requestDto.getData().getName();
//        //수신번호 형태에 맞춰 "-"을 ""로 변환
//        String phoneNum = requestDto.getData().getPhoneNumber().replaceAll("-","");
//
//        User foundUser = userRepository.findByNameAndPhone(name, phoneNum).orElseThrow(()->
//                new NoSuchElementException("회원이 존재하지 않습니다."));
//
//        String receiverEmail = foundUser.getEmail();
//        String verificationCode = validationUtil.createCode();
//        smsUtil.sendOne(phoneNum, verificationCode);
//
//        //인증코드 유효기간 5분 설정
//        redisUtil.setDataExpire(verificationCode, receiverEmail, 60 * 5L);
//
//        return ;
//    }
//}
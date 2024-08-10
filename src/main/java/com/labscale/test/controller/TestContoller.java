package com.labscale.test.controller;

import com.labscale.test.dto.req.APIRequest;
import com.labscale.test.dto.req.LocationReqDTO;
import com.labscale.test.dto.res.ApiResponse;
import com.labscale.test.dto.res.LocationResDTO;
import com.labscale.test.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class TestContoller {
    private final LocationService locationService;

    // 위치 찾기 API
    @PostMapping("/locationlist")
    public ApiResponse<LocationResDTO> findLocation(@RequestBody APIRequest<LocationReqDTO> req) {
        // API secretKey 체크 BeforeAdvice는 AOP로
        // request Log 생성 BeforeAdvice는 AOP로

        // `req`에서 `data` 필드를 추출하고, 위도와 경도를 가져옴
        LocationReqDTO locationData = req.getData();
        double latitude = locationData.getLatitude();
        double longitude = locationData.getLongitude();

        // 위도와 경도 값 바탕으로 resData 생성
        LocationResDTO res = locationService.getLocationData(latitude, longitude);
        // response Log 생성 After Advice

        // 리턴값 생성
        ApiResponse<LocationResDTO> response = new ApiResponse<>();
        response.setApiSvcId("CM02");
        response.setResultCode("0000");
        response.setResultMessage("성공적으로 호출되었습니다");
        response.setResData(res);
        return response;
    }

    /**
     *  성공 json 예시 "{\n" +
     *                 "  \"apiSvcId\": \"CM01\",\n" +
     *                 "  \"resultCode\": \"200\",\n" +
     *                 "  \"resultMessage\": \"성공적으로 호출되었습니다\",\n" +
     *                 "  \"resData\": {\n" +
     *                 "    \"list\": [\n" +
     *                 "      {\n" +
     *                 "        \"title\": \"아이폰 팝니다.\",\n" +
     *                 "        \"detail\": \"부산광역시 사상구\",\n" +
     *                 "        \"money\": \"4000\",\n" +
     *                 "        \"writingTime\": \"26\",\n" +
     *                 "        \"imageUrl\": \"\"\n" +
     *                 "      },\n" +
     *                 "      {\n" +
     *                 "        \"title\": \"아이폰 팝니다.2\",\n" +
     *                 "        \"detail\": \"부산광역시 사상구2\",\n" +
     *                 "        \"money\": \"4000\",\n" +
     *                 "        \"writingTime\": \"26\",\n" +
     *                 "        \"imageUrl\": \"\"\n" +
     *                 "      },\n" +
     *                 "      {\n" +
     *                 "        \"title\": \"아이폰 팝니다.2\",\n" +
     *                 "        \"detail\": \"부산광역시 사상구2\",\n" +
     *                 "        \"money\": \"4000\",\n" +
     *                 "        \"writingTime\": \"26\",\n" +
     *                 "        \"imageUrl\": \"\"\n" +
     *                 "      },\n" +
     *                 "      {\n" +
     *                 "        \"title\": \"아이폰 팝니다.2\",\n" +
     *                 "        \"detail\": \"부산광역시 사상구2\",\n" +
     *                 "        \"money\": \"4000\",\n" +
     *                 "        \"writingTime\": \"26\",\n" +
     *                 "        \"imageUrl\": \"\"\n" +
     *                 "      },\n" +
     *                 "      {\n" +
     *                 "        \"title\": \"아이폰 팝니다.2\",\n" +
     *                 "        \"detail\": \"부산광역시 사상구2\",\n" +
     *                 "        \"money\": \"4000\",\n" +
     *                 "        \"writingTime\": \"26\",\n" +
     *                 "        \"imageUrl\": \"\"\n" +
     *                 "      }\n" +
     *                 "    ]\n" +
     *                 "  }\n" +
     *                 "}";
     * @return
     */
    @GetMapping("homelistdatas")
    public String test() {

        return null;
    }


    @PostMapping("setmylocation")
    public String setMyLocation() {
        return "{\n" +
                "  \"apiSvcId\": \"CM01\",\n" +
                "  \"resultCode\": \"200\",\n" +
                "  \"resultMessage\": \"성공적으로 호출되었습니다.\",\n" +
                "  \"resData\": {\n" +
                "    \"resultCode\": \"0000\",\n" +
                "    \"resultMessage\": \"성공적으로 저장되었습니다.\"\n" +
                "  }\n" +
                "}";
    }

    @GetMapping("getchatlist")
    public String getChatList() {
        return "{\n" +
                "  \"apiSvcId\": \"getChatList\",\n" +
                "  \"resultCode\": \"200\",\n" +
                "  \"resultMessage\": \"Success\",\n" +
                "  \"resData\": {\n" +
                "    \"list\": [\n" +
                "      {\n" +
                "        \"isUser\": true,\n" +
                "        \"message\": \"안녕하세요, 어떻게 지내세요?\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"isUser\": false,\n" +
                "        \"message\": \"저는 잘 지내요, 감사합니다! 당신은 어떻게 지내세요?\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"isUser\": true,\n" +
                "        \"message\": \"저도 잘 지내고 있어요, 감사합니다!\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";
    }
}

package hello.springmvc.basic.response;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@RestController
@Slf4j  // 로그 찍는 롬복 라이브러리 log 바로 사용가능
@Controller
public class ResponseBodyController {

    // 서블릿을 직접 다룰때처럼 , HttpServletResponse객체를 통해서 Http 메세지 바디에 직접 응답메세지 전달
    @GetMapping("/response-body-string-v1")
    public void reposneBodyV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    //
    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> reposneBodyV2() throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/response-body-string-v3")
    @ResponseBody
    public String reposneBodyV3(){
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> reposneBodyJsonV1(){
        HelloData helloData=new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/response-body-json-v2")
    @ResponseBody  // 여기서 @ReponseBody 가 붙어서 helloData의 객체 데이터를 JSON 으로 반환
    public HelloData responseBodyJsonV2(){
        HelloData helloData=new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(20);

        return helloData;
    }



}

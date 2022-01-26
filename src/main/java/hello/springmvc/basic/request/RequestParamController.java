package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request , HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody // @RestController와 같은 효과 - 메세지 바디에 띄움.
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge ){

        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }

    @ResponseBody // @RestController와 같은 효과 - 메세지 바디에 띄움.
    @RequestMapping("/request-param-required")
    public String requestParamV4(
            @RequestParam(value = "username",required = true) String memberName,   // 필수값
            @RequestParam(value = "age",required = false) int memberAge
            //age  필수값은 아니다. 하지만 이대로 돌리면 500대 오류->
            //int 는 기본값 0 인데, null 이 와야 문제가 없어지게 된다. Integer memberAge 로 바꿔주면 객체가 null 인 상태로 간주해서 정상작동한다.
    ){

        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }
    @ResponseBody // @RestController와 같은 효과 - 메세지 바디에 띄움.
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(value = "username",required = true,defaultValue = "guest") String memberName,   // 필수값
            @RequestParam(value = "age",required = false,defaultValue = "-1") int memberAge
            //age  필수값은 아니다. 하지만 이대로 돌리면 500대 오류->
            //int 는 기본값 0 인데, null 이 와야 문제가 없어지게 된다. Integer memberAge 로 바꿔주면 객체가 null 인 상태로 간주해서 정상작동한다.
    ){

        log.info("username={}, age={}",memberName,memberAge);
        return "ok";
    }
    @ResponseBody // 해당 파라미터 값이 한개임이 확실할때는 Map을 사용한다.
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String,Object> paramMap){
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));
        return "ok";
    }

    @ResponseBody // 해당 파라미터의 값이 여러개일 경우 MultiValueMap 을 사용한다.
    @RequestMapping("/request-param-multivaluemap")
    public String requestParamMap(@RequestParam MultiValueMap<String,Object> multiValueMap){

        log.info("username={}, age={}",multiValueMap.get("username"),multiValueMap.get("age"));
        return "ok";
    }
    @ResponseBody // 해당 파라미터의 값이 여러개일 경우 MultiValueMap 을 사용한다.
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam("username") String username, @RequestParam("age") int age){
        HelloData helloData=new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());


        return "ok";

    }
    @ResponseBody // 해당 파라미터의 값이 여러개일 경우 MultiValueMap 을 사용한다.
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}",helloData.getUsername(),helloData.getAge());


        return "ok";

    }

}

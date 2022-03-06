package hello.springmvc.basic;


import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller 를 사용하면 뷰 이름을 반환하기 때문에 @RestController 애노테이션 사용
@Slf4j
public class LogTestController {
//    private final Logger log= LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name ="Spring";
        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        /* info 레벨만 출력되도록 하는 것을 application.properties에서 설정가능 -> soutv 로 설정하면
         로그 정보가 다 남게 된다. 필요한 로그 정보만 남기도록 하기 위함이다.
         개발서버에서는 logging.level.hello.springmvc=debug ,
         운영서버에서는 logging.level.hello.springmvc=info 로 바꿔서 쓰곤한다. */

        log.info("info log={}",name);
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        return "ok";
    }
}
// 밑과 같은 방식으로 로그가 남게 된다.
//2022-03-06 13:34:09.182  WARN 8236 --- [nio-8080-exec-1] hello.springmvc.basic.LogTestController  : warn log=Spring
//2022-03-06 13:34:09.183 ERROR 8236 --- [nio-8080-exec-1] hello.springmvc.basic.LogTestController  : error log=Spring

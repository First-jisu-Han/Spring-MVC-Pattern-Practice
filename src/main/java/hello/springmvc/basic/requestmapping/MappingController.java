package hello.springmvc.basic.requestmapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
public class MappingController {

    private final Logger log= LoggerFactory.getLogger(getClass());

    @RequestMapping(value="/hello-basic",method=RequestMethod.GET)  // GET만 하용, 다른걸로하면 405 오류가 나온다.
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")    // GET 만 허용 , 다른건 405 오류가 나온다. + userId
    public String mappingPath(@PathVariable("userId")String data){
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    @PostMapping(value = "/mapping-consume",consumes="application/json")   // contentType이 json인 경우에만 호출된다.
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}

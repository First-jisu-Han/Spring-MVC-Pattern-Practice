package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

/*

회원 목록 조회: GET
        회원 등록: POST
        회원 조회: GET
        회원수정: PATCH /users/{userId} 회원 삭제: DELETE /users/{userId}
        /users
        /users
        /users/{userId}
*/

@RestController
public class MappingClassController {

    @GetMapping("/mapping/users")
    public String user(){
        return "get users";
    }  // 응답결과 : get users
    @PostMapping("/mapping/users")
    public String addUser(){
        return "post user";
    }  // 응답 결과 : post user
    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userId" + userId;
    }    // 응답결과 : get userId userA
    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable String userId){
        return "update userId" +userId ;
    }    // 응답결과 : update userId userA
    @DeleteMapping("/mapping/users/{userId}")
    public String DeleteUser(@PathVariable String userId){
        return "delete userId" +userId ;
    }    // 응답결과 : delete userId userA


}

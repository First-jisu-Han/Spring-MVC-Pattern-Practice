package hello.springmvc.basic;

import lombok.Data;

@Data    // 롬복의 getter setter toString EqualsAndHashCode RequiredArgsConstructor를
public class HelloData {
    private String username;
    private int age;

}

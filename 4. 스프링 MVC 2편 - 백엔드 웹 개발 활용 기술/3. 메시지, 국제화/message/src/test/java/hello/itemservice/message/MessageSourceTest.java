package hello.itemservice.message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

//    @Test
//    void helloMessage() {
//        String result = ms.getMessage("hello", null, null);
//        // 지역 설정이 default로 되어있어서 "안녕"이 실행이 됨
//        assertThat(result).isEqualTo("안녕");
//    }
//    @Test
//    void notFoundMessageCodeDefaultMessage() {
//        String result = ms.getMessage("no_code", null, "기본 메시지", null);
//        assertThat(result).isEqualTo("기본 메시지");
//    }
//
//    @Test
//    void argumentMessage() {
//        String result = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
//        // 값을 넘겨서 치환하는데 Object[] 배열을 사용
//        assertThat(result).isEqualTo("안녕 Spring");
//    }
//
//    @Test
//    void defaultLang() {
//        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
//        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
//    }
//
//    @Test
//    void enLang() {
//        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
//    }
}
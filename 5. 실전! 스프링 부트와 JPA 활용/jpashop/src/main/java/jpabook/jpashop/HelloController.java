package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){// 데이터를 model에 실어서 뒤로 넘김
        model.addAttribute("data", "hello!!");
        return "hello";//hello.html으로 연결
    }
}

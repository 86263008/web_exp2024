package edu.xust.hellospringboot;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // 允许所有来源的跨域请求
public class HelloSpringBootController {

    @RequestMapping("/hi")
    public String Hi(@RequestParam String name) {
        return "Hello, " + name + ":" + LocalDateTime.now();
    }
}
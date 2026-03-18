package edu.xust.hellospringboot;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBootController {

    @GetMapping("/hi")
    public String Hi(@RequestParam String name) {
        return "Hello, " + name + "!:" + LocalDateTime.now();
    }
}
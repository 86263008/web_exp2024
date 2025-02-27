package xust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.servlet.ModelAndView;

@RestController
@EnableTransactionManagement
@MapperScan("xust.*")
@SpringBootApplication
public class StuApplication {

    @GetMapping("/")
    ModelAndView home() {
      ModelAndView mv = new ModelAndView("home");
      return mv;
    }

    @GetMapping("/greeting")
    ModelAndView greeting() {
      ModelAndView modelAndView = new ModelAndView("greeting");
      modelAndView.addObject("message", "Hello, World!");
      return modelAndView;
    }  

    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class, args);
    }
}


package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
public class HelloController extends SpringBootServletInitializer {

	@RequestMapping("/hello")
    @ResponseBody
    String home() throws FileNotFoundException {

          String path = ResourceUtils.getURL("classpath:").getPath();
          System.out.println(path);
        return "Hello ,spring boot!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
        //运行之后在浏览器中访问：http://localhost:8080/hello
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(HelloController.class);
    }
	
}

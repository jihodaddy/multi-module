package com.example;

import com.example.exception.CustomException;
import com.example.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;
    @GetMapping("/test")
    public String test() {
        return testService.test();
    }

}
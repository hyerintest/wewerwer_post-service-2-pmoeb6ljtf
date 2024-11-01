package com.tlc.test.controller;

import com.tlc.test.response.ResponseObject;
import com.tlc.test.service.SampleMyBatisService;
import com.tlc.test.vo.SampleVo;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.Callable;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SampleMyBatisController {

    private final SampleMyBatisService service;

    @PostMapping(value = "/db-test")
    public Callable<ResponseObject> post(@RequestBody SampleVo vo) {
        return () -> service.post(vo);
    }

    @GetMapping(value = "/db-test")
    public Callable<ResponseObject> get() {
        return () -> service.get();
    }

    @DeleteMapping("/db-test/{id}")
    public Callable<ResponseObject> delete(@PathVariable String id) {
        return () -> service.delete(id);
    }
}

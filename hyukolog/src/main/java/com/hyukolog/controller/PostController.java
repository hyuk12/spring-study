package com.hyukolog.controller;

import com.hyukolog.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class PostController {

    // SSR  -> jsp, thymeleaf, mustache, freemarker
    // html rendering
    // SPA ->
    // vue -> vue + SSR = nuxt
    // javascript ->
    // react -> react + SSR = next

    // Http Method
    // GET,  POST, PUT, DELETE, PATCH, OPTIONS, CONNECT, HEAD,  TRACE
    // 글 등록
    // POST Method

    @PostMapping ("/posts")
    public String post(@RequestBody PostCreate params){
        log.info("params={}", params.toString());
        return "Hello world!";
    }
}

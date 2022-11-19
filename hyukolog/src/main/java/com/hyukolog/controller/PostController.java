package com.hyukolog.controller;

import com.hyukolog.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // 데이터를 검증하는 이유

        // 1. client 개발자가 깜박할 수 있다. 실수로 값을 안보낼 수 있다.
        // 검증 부분에서 버그가 발생할 여지가 높다.
        // 2. client bug 로 값이 누락될 수 있다.
        // 3. 외부에 나쁜사람이 값을 임의로 조작해서 보낼수 있다.
        // 4. DB에 값을 저장할 때 의도치 않은 오류가 발생할 수 있다.
        // 5. 서버 개발자의 편안함을 위해서.

//        String title = params.getTitle();
//        if (title == null || title.equals("")){
//            // 1. 계속 if 문을 만들어서 에러를 발생시키면 빡시다.
//            // 2. 개발팁 -> 무언가를 3번이상 반복 작업을 할 때에는 내가 뭔가 잘못하고 있는건 아닐지 의심한다.
//            // 3. 누락가능성이 생긴다.
//            // 4. **생각보다 검증할게 많다.** (꼼꼼하지 않을 수 있다.)
//            // 5. 개발자 스럽지 않다.
//            throw new Exception("타이틀 값이 없어요!");
//        }
//
//        String content = params.getContent();
//        if (content == null || content.equals("")){
//            // error
//        }
@Slf4j
@RestController
public class PostController {


    @PostMapping ("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result)  {
        log.info("params={}", params.toString());
        if (result.hasErrors()){
          List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField();
            String errorMessage = firstFieldError.getDefaultMessage();

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }
        return Map.of();
    }
}

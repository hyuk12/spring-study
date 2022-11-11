package com.study.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j // 로깅 추상화 라이브러리 : 로깅을 직접 하지 않고 로깅 구현체를 찾아 기능을 사용할 수 있게 해주는 것
public class LoggerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("=======================================");
        log.debug("=============== BEGIN =================");
        log.debug("Request URI ===>" + request.getRequestURI());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("=============== END =================");
        log.debug("=======================================");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}

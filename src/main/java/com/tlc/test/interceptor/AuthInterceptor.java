package com.tlc.test.interceptor;

import com.tlc.test.utility.LogUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuthInterceptor implements AsyncHandlerInterceptor {

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) {
        if (handler instanceof HandlerMethod) {
            LogUtils.accessLog(LogManager.getLogger(((HandlerMethod) handler).getBeanType().getName()), request);
        }
    }
}

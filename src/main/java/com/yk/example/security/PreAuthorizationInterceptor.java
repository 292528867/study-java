package com.yk.example.security;

import com.yk.example.entity.primary.User;
import com.yk.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yk on 16/2/23.
 */
public class PreAuthorizationInterceptor extends HandlerInterceptorAdapter {


    public static final String TOKEN = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request = [" + request + "], response = [" + response + "], handler = [" + handler.getClass() + "]");
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            PreAuthorise preAuthorise = method.getMethodAnnotation(PreAuthorise.class);
            if (preAuthorise != null) {
                System.out.println("PreAuthorizationInterceptor.preHandle");
                String token = request.getHeader(TOKEN);
                if (token == null || token.isEmpty()) {
                    token = request.getParameter(TOKEN);
                }
                if (token == null || token.isEmpty()) {
                    response.sendError(HttpStatus.FORBIDDEN.value());
                    return false;
                }

                //获取bean
                WebApplicationContext context = WebApplicationContextUtils.
                        getRequiredWebApplicationContext(request.getServletContext());
                UserService userService = context.getBean(UserService.class);
                User user = userService.findByToken(token);
                if (user == null) {
                    response.sendError(HttpStatus.FORBIDDEN.value());
                    return false;
                }
            }
        }
        return true;
    }
}

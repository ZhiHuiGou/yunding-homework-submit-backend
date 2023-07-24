package com.yundingshuyuan.web.common.interceptor;

import com.yundingshuyuan.web.utils.RedisUtil;
import com.yundingshuyuan.web.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author cr
 * @Date 2023/7/22 19:59
 */
@Component
public class TokenInterceptor implements HandlerInterceptor{

    @Autowired
    RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //给OPTIONS放行
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }

        String authorization = request.getHeader("Authorization");
        if (TokenUtil.checkToken(authorization)){
            //查验redis中有无该token
            if (redisUtil.get(authorization) != null){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

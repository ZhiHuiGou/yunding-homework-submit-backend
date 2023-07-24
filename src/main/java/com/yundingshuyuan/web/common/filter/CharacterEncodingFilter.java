package com.yundingshuyuan.web.common.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author cr
 * @Date 2023/7/22 21:26
 */
@WebFilter(urlPatterns = "/**" , filterName = "CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        /*设置请求的字符编码为UTF-8*/
        request.setCharacterEncoding("UTF-8");

        /*设置响应的字符编码为UTF-8*/
        response.setCharacterEncoding("UTF-8");

        /*添加到过滤链当中*/
        filterChain.doFilter(request , response);
    }
}

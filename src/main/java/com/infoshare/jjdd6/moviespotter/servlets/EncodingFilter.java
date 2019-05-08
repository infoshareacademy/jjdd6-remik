package com.infoshare.jjdd6.moviespotter.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/programme/", "/programme/*", "/error"})
public class EncodingFilter implements Filter {

    private String encoding = "utf-8";
    private String contentType = "text/html;charset=UTF-8";

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        request.setCharacterEncoding(encoding);
        response.setContentType(contentType);
        filterChain.doFilter(request, response);
    }
}
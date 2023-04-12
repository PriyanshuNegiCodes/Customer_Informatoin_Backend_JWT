package com.example.CustomerInformation.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        String authHeader= httpServletRequest.getHeader("Authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer")){
            throw new ServletException("The token is missing");
        }else {
            String token=authHeader.substring(7);
            System.out.println("this is token "+token);
            Claims claims= Jwts.parser().setSigningKey("SecretKey").parseClaimsJws(token).getBody();

            httpServletRequest.setAttribute("attr1", claims.get("customerName"));
            httpServletRequest.setAttribute("attr2", claims.get("customerPassword"));

            System.out.println("*************************************************");
            System.out.println("This is the attr1 "+claims.get("customerName")+" This is the attr2 "+claims.get("customerPassword"));

        }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

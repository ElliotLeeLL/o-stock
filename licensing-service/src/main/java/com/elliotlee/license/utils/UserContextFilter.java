package com.elliotlee.license.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName UserContextFilter
 * @Description Class created by Elliot Lee
 * @Author Elliot Lee
 * @Date 1/21/2025 8:35 PM
 */
@Slf4j
@Component
public class UserContextFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        UserContextHolder.getUserContext().setCorrelationId(httpServletRequest.getHeader(UserContext.CORRELATION_ID));
        UserContextHolder.getUserContext().setUserId(httpServletRequest.getHeader(UserContext.USER_ID));
        UserContextHolder.getUserContext().setAuthToken(httpServletRequest.getHeader(UserContext.AUTH_TOKEN));
        UserContextHolder.getUserContext().setOrganizationId(httpServletRequest.getHeader(UserContext.ORGANIZATION_ID));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}

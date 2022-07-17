package ru.michaelshell.http.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.michaelshell.http.dto.UserDto;

import java.io.IOException;

@WebFilter("/admin")
public class UnsafeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        if (user == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/registration");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

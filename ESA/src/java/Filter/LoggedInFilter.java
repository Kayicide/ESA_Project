/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Bean.UserBean;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kayde
 */
@WebFilter(filterName = "LoggedInFilter", urlPatterns = {"/faces/*"})
public class LoggedInFilter implements Filter {
    @Inject UserBean user;
    private FilterConfig filterConfig = null;
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain)throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String loginURI = request.getContextPath() + "/faces/login.xhtml";
        String registerURI = request.getContextPath() + "/faces/register.xhtml";
        String homeURI = request.getContextPath() + "/faces/index.xhtml";

        System.out.println(homeURI);
        System.out.println(request.getRequestURI());
        
        
        boolean loggedIn = user.getLoggedIn();
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean registerRequest = request.getRequestURI().equals(registerURI);
        boolean homeRequest = request.getRequestURI().equals(homeURI);
        boolean firstLoad = request.getRequestURI().equals("/ESA/");
        boolean isStaticResource = request.getRequestURI().startsWith(request.getContextPath() + "/faces" + ResourceHandler.RESOURCE_IDENTIFIER);

        if (loggedIn || loginRequest || registerRequest || homeRequest || isStaticResource || firstLoad)
        {
            System.out.println("Allowed");
            chain.doFilter(request, response);
        }
        else
        {
            System.out.println("Denied");
            response.sendRedirect(loginURI);
        }
    }

    public void destroy() {  
        this.filterConfig = null;
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }
    
    public void log(String msg){
        filterConfig.getServletContext().log(msg);
    }  
    
}
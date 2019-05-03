/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Bean.UserBean;
import java.io.IOException;
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
@WebFilter(filterName = "AdminFilter", urlPatterns = {"/faces/admin/*"})
public class AdminFilter implements Filter {
    private FilterConfig filterConfig = null;
    public AdminFilter() {}
    @Inject UserBean userBean;
    
    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        String home = request.getContextPath() + "/faces/index.xhtml";
        
        boolean admin;
        if(userBean.getCurrentUser() == null){
            admin = false;
        }else{
            admin = userBean.getCurrentUser().isIsAdmin();
        }
        System.out.println(admin + "FILTER");
        boolean isStaticResource = request.getRequestURI().startsWith(request.getContextPath() + "/faces" + ResourceHandler.RESOURCE_IDENTIFIER);
        
        if (admin || isStaticResource)
        {
            chain.doFilter(request, response);
        }
        else
        {
            response.sendRedirect(home);
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }


    public void destroy() {  
        this.filterConfig = null;
    }

    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}

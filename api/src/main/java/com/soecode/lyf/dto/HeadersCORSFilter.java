package com.soecode.lyf.dto;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HeadersCORSFilter
 */
@WebFilter("/HeadersCORSFilter")
public class HeadersCORSFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HeadersCORSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁解决跨域问题的过滤器。。");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse servletResponse,
            FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 HttpServletResponse response = (HttpServletResponse) servletResponse;
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
         response.setHeader("Access-Control-Max-Age", "3600");
         response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
         response.setHeader("Access-Control-Allow-Credentials","true");
         
         //设置禁用浏览器缓冲，但是全局的修改禁用，会不会影响其他例如用户信息的缓冲的功能？？？/待测试
        /* response.setHeader("If-Modified-Since", "0");
         response.setHeader("Cache-Control", "no-cache");  
         response.setHeader("Pragma", "no-cache");  
         response.setDateHeader("Expires", -1);  */
         chain.doFilter(request, servletResponse);
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("解决跨域问题的过滤器，启动执行过滤器。。");
	}

}

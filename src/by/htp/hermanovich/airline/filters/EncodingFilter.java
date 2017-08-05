package by.htp.hermanovich.airline.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Description: This filter provides encoding content.
 *
 * Created by Yauheni Hermanovich on 24.07.2017.
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
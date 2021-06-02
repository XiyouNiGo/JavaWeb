package xupt.se.ttms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * 解决字符编码问题
 */
@WebFilter(urlPatterns = "/*", initParams =
        {@WebInitParam(name = "encoding", value = "UTF-8")})
public class CharsetEncodingFilter implements Filter {
    private String encoding = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpreq = (HttpServletRequest) request;
        if (httpreq.getMethod().equalsIgnoreCase("POST")) {
            // post方式发送，直接设置字符集
            request.setCharacterEncoding(encoding);
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
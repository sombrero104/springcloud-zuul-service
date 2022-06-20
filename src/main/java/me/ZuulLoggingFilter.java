package me;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("***************************** printing logs : ");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        logger.info("***************************** " + request.getRequestURI());
        return null;
    }

    @Override
    public String filterType() {
        return "pre"; // 사전 필터
        // return "post"; // 사후 필터
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}

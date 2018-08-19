package lzj.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */

public class FirstInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     * return false 无法执行目标方法 postHandle afterCompletion也不再执行,后续的拦截器也无法在执行
     * return true  执行后续的拦截器,继而执行目标方法
     * 可用于判断权限 日志 事务
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        System.out.println("FirstInterceptor preHandle");
        return true;
    }

    /**
     * 调用目标方法之后 渲染视图之前
     * 可用于 修改请求域对象中属性或对视图做修改
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)
            throws Exception {
        System.out.println("FirstInterceptor postHandle");
    }

    /**
     * 渲染视图之后
     * 可用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)
            throws Exception {
        System.out.println("FirstInterceptor afterCompletion");
    }
}





package Interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //获取支架url地址
        String uri = request.getRequestURI();
        String path = uri.substring(request.getContextPath().length());  //去掉项目地址长度的字符
        String query = request.getQueryString();  //获取参数
        if (query==null){
            query="";
        }else {
            query="?"+query;
        }
        String beforepath=path+query;
        session.setAttribute("beforepath",beforepath);
        session.setAttribute("method",request.getMethod());  //获取提交方式post、get

        Object name = session.getAttribute("uname");
        if (name!=null){
            return true;
        }else {
            response.sendRedirect(request.getContextPath() + "/User/ToLogin.do");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

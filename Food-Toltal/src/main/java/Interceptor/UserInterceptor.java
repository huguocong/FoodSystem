package Interceptor;

import Service.UserService;
import Utils.CookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从session域获取
        HttpSession session = request.getSession();
        Object name = session.getAttribute("uname");
        if (name!=null){
            return true;
        }
        //从cookie获取登录名密码
        Cookie autologin = CookUtils.getCookieByName("uautologin", request.getCookies());
        if (autologin!=null){
            String[] split = autologin.getValue().split("@");
            String username1=split[0];
            String password1=split[1];
            User user = new User(username1, password1);
            User login = userService.Login(user);
            if (login!=null){
                request.getSession().setAttribute("uname",login.getName());
                request.getSession().setAttribute("uuserid",login.getId());
                return true;
            }else {
                session.setAttribute("error","用户名或密码错误");
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

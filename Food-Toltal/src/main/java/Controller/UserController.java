package Controller;

import My.Login;
import My.Result;
import Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("User")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("ToLogin")
    public String ToLogin(){
        return "jsp/login";
    }

    @RequestMapping("ToRsgister")
    public String ToRegister(){
        return "jsp/Register";
    }

    @RequestMapping("Login")
    @ResponseBody
    public Result Login(@RequestBody Login login, HttpServletRequest request, HttpServletResponse response)throws Exception {
        if (login.getUsername() != null && login.getPassword() != null) {
            User user = new User(login.getUsername(), login.getPassword());
            User login1 = userService.Login(user);
            //登录成功
            if (login1 != null && login1.getGroupid()!= 0) {
                //设置昵称,登录名到session域
                request.getSession().setAttribute("uname", login1.getName());
                request.getSession().setAttribute("uuserid", login1.getId());
                if (login.getAutologin() != null) {
                    //选择了自动登录
                    Cookie autologin = new Cookie("uautologin", login1.getUsername() + "@" + login1.getPassword());
                    autologin.setMaxAge(60 * 60 * 24 * 7);
                    autologin.setPath("/");
                    response.addCookie(autologin);
                } else {
                    //没有选择自动登录清除cookie
                    Cookie autologin = new Cookie("uautologin", "");
                    autologin.setMaxAge(0);
                    autologin.setPath("/");
                    response.addCookie(autologin);
                }
                if (login.getRemebername() != null) {
                    //选择了记住用户名
                    Cookie remerber = new Cookie("uremebername", login1.getUsername());
                    remerber.setMaxAge(60 * 60 * 24 * 7);
                    remerber.setPath("/");
                    response.addCookie(remerber);
                } else {
                    //没有选择清除cookie
                    Cookie remerber = new Cookie("uremebername", "");
                    remerber.setMaxAge(0);
                    remerber.setPath("/");
                    response.addCookie(remerber);
                }
                String beforepath=(String) request.getSession().getAttribute("beforepath");
                String method=(String) request.getSession().getAttribute("method");
               /* if (beforepath!=null){
                    if ("POST".equals(method)){  //请求转发默认使用的是post方式，不支持get方式
                        request.getRequestDispatcher(beforepath).forward(request,response);
                    }else {//如果是GET方式，就使用重定向，重定向默认使用的是GET方式。request.getContextPath()获得项目地址
                        response.sendRedirect(request.getContextPath()+beforepath);
                    }
                }*/
               String message="/index.do";
               if (beforepath!=null){
                    message=beforepath;
               }
                return new Result(true,message);

            } else {
                //登录失败
                request.getSession().setAttribute("loginerror", "用户名密码错误");
                return new Result(false,"用户名密码错误");
            }
        } else {
            //传值为空
            return new Result(false,"用户名密码为空");
        }
    }


    @RequestMapping("CheckUsername")
    @ResponseBody
    public Result CheckUsername(String username){
        if (userService.CheekUsername(username)) {
            return new Result(true, "用户名可用");
        }else {
            return new Result(false, "用户名已经存在");
        }


    }
    @RequestMapping("Register")
    @ResponseBody
    public Result Register(@RequestBody User user){
        try {
            userService.Register(user);
            return new Result(true,"注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"注册失败");
        }
    }

    @RequestMapping("LoginOut")
    public String LoginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "jsp/login";
    }
}

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
@RequestMapping("AdminUser")
public class AdminUserController {

    @Resource
    private UserService userService;

    @RequestMapping("ToLogin")
    public String ToLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //只能转发访问WEB-INF
        // request.getRequestDispatcher("/WEB-INF/admin/jsp/login.jsp").forward(request,response);
        //跳出iframe
        return "admin/jsp/ToLogin";
    }

    @RequestMapping("Login")
    @ResponseBody
    public Result Login(HttpServletRequest request, HttpServletResponse response, @RequestBody Login login){
        if (login.getUsername()!=null&&login.getPassword()!=null){
            User user = new User(login.getUsername(), login.getPassword());
            User login1 = userService.Login(user);
            //登录成功
            if (login1!=null&&login1.getGroupid()==0){
                //设置昵称,登录名到session域
                request.getSession().setAttribute("name",login1.getName());
                request.getSession().setAttribute("username",login1.getUsername());
                if (login.getAutologin()!=null){
                    //选择了自动登录
                    Cookie autologin = new Cookie("autologin", login1.getUsername() + "@" + login1.getPassword());
                    autologin.setMaxAge(60*60*24*7);
                    autologin.setPath("/");
                    response.addCookie(autologin);
                }else {
                    //没有选择自动登录清除cookie
                    Cookie autologin = new Cookie("autologin","");
                    autologin.setMaxAge(0);
                    autologin.setPath("/");
                    response.addCookie(autologin);
                }
                if (login.getRemebername()!=null){
                    //选择了记住用户名
                    Cookie remerber = new Cookie("remebername", login1.getUsername() );
                    remerber.setMaxAge(60*60*24*7);
                    remerber.setPath("/");
                    response.addCookie(remerber);
                }else {
                    //没有选择清除cookie
                    Cookie remerber = new Cookie("remebername","");
                    remerber.setMaxAge(0);
                    remerber.setPath("/");
                    response.addCookie(remerber);
                }
                return new Result(true,"登录成功");
            }else {
                //登录失败
                request.getSession().setAttribute("loginerror","用户名密码错误");
                return new Result(false,"用户名密码错误");
            }
        }else {
            //传值为空
            return new Result(false,"用户名密码为空");
        }
    }

    @RequestMapping("LoginOut")
    public String LoginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "admin/jsp/login";
    }

    @RequestMapping("UpdataPwd")
    @ResponseBody
    public Result UpdataPwd(HttpServletRequest request,String newpassword,String oldpassword){
        try {
            //获取登录名
            String username = (String) request.getSession().getAttribute("username");
            if (username==null){
                return new Result(false,"用户登录过期，请重新登录");
            }
            if (newpassword==null||oldpassword==null){
                return new Result(false,"密码不能为空");
            }
            User olduser = new User(username, oldpassword);
            User login = userService.Login(olduser);
            if (login==null){
                return new Result(false,"原密码错误");
            }
            login.setPassword(newpassword);
            userService.UpdataPwd(login);
            return new Result(true,"更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新失败");
        }

    }

}

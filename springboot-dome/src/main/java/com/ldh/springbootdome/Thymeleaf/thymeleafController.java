package com.ldh.springbootdome.Thymeleaf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * thymeleafController
 */
@Controller
@RequestMapping("/thymeleaf")
public class thymeleafController {

    @RequestMapping("/show")
    public String ThymeleafShow(HttpServletRequest request, Model model) {
        // Model addAttribute 添加模型数据设置到request域中
        model.addAttribute("msg", "thymeleaf基本用法");

        // 集合用法
        List<stduser> userlist = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            stduser user = new stduser();
            user.setUserId(i);
            user.setUserName("张三" + i);
            userlist.add(user);
        }

        model.addAttribute("userlist", userlist);

        // 时间
        model.addAttribute("date", new Date());

        //作用域用法
        request.setAttribute("request", "获取request对象:${#httpServletRequest.getAttribute('request')}");
        request.getSession().setAttribute("session", "获取session值:th:text=${session.session}");
        request.getSession().getServletContext().setAttribute("context", "获取ServletContext:${application.context}");
  

        return "thymeleaf";
    }

    public class stduser {
        private int userId;
        private String userName;

        /**
         * @return the userId
         */
        public int getUserId() {
            return userId;
        }

        /**
         * @return the userName
         */
        public String getUserName() {
            return userName;
        }

        /**
         * @param userName the userName to set
         */
        public void setUserName(String userName) {
            this.userName = userName;
        }

        /**
         * @param userId the userId to set
         */
        public void setUserId(int userId) {
            this.userId = userId;
        }

    }

}

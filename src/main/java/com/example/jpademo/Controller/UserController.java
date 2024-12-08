package com.example.jpademo.Controller;

import com.example.jpademo.Service.UserService;
import com.example.jpademo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() { // 로그인
        return "login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        User user = userService.loginUser(email, password); // 로그인 처리
        if (user == null) { // 로그인 실패
            model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
            System.out.println("로그인 실패");
            return "login";
        }
        return "redirect:/cocktail/";
    }

    @GetMapping("/signup")
    public String signup() { // 회원가입
        return "signup";
    }

    @RequestMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        User registeredUser = userService.registerUser(user); // 회원가입 처리
        if (registeredUser == null) {
            model.addAttribute("error", "이미 사용 중인 이메일입니다.");
            return "signup";
        }
        return "redirect:/login"; // 회원가입 성공 후 로그인 페이지로 리다이렉트
    }
}
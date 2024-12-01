package com.example.jpademo.Service;

import com.example.jpademo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jpademo.Entity.User;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            System.out.println("이미 존재하는 사용자입니다.");
            return null; // 이메일이 이미 존재하면 null 반환
        }
        System.out.println("회원가입 성공");
        return userRepository.save(user); // 사용자 저장
    }

    public User loginUser(String email, String pw) { // 로그인 시 user테이블에서 사용자 정보(eamil, pw) 조회
        return userRepository.findByEmailAndPw(email, pw).orElse(null);
    }
}

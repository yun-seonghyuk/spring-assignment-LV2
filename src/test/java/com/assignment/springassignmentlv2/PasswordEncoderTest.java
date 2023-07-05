package com.assignment.springassignmentlv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("수동 등록한 passwordEncoder를 주입 받아와 문자열 암호화")
    void test1(){
        String pw = "2222";

        // 암호화된 비밀번호
        String encodePassword = passwordEncoder.encode(pw);

        String inputPassword = "2222";
        System.out.println(encodePassword);

        // 복호화를 통해 암호화된 비밀번호와 비교
        boolean matches = passwordEncoder.matches(inputPassword,encodePassword);
        System.out.println("matches = "+matches);
    }
}

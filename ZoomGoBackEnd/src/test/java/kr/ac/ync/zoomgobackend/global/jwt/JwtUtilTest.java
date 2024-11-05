package kr.ac.ync.zoomgobackend.global.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtUtilTest {


    @Autowired
    private JwtUtil jwtUtil;


    @Test
    void testGeneratedAccessToken()
    {
        String accessToken = jwtUtil.generateAccessToken("test@example.com");
        System.out.println(accessToken);
        System.out.println("======================================================");

    }
}
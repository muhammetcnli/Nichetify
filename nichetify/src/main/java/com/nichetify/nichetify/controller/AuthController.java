package com.nichetify.nichetify.controller;

import com.nichetify.nichetify.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("login")
    public String login(){
        return authService.getLoginUri();
    }

    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code, HttpServletResponse response) throws IOException {
        try {
            String accessToken = authService.handleCallback(code);
            response.sendRedirect("/me");
            return accessToken;
        } catch (Exception e) {
            // catch error
            return "Error" + e.getMessage();
        }
    }
}

package com.main.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lneoi.li
 * @ClassName loginController
 * @Description
 * @date 2019/8/8 11:46
 **/
@RestController
@RequestMapping("/test")
public class loginController {

    @GetMapping("/index")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("index");
    }

    @PostMapping("/login_p")
    public ResponseEntity<String> login() {
        int a = 1;
        return ResponseEntity.ok().body("index");
    }



}

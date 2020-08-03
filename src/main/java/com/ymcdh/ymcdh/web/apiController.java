package com.ymcdh.ymcdh.web;

import com.ymcdh.ymcdh.Dto.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class apiController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Posts> insert(@RequestBody Posts user)
    {
        postService.insert(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<Posts> update(@RequestBody Posts user)
    {
        postService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

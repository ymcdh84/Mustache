package com.ymcdh.ymcdh.web;

import com.ymcdh.ymcdh.Dto.Posts;
import com.ymcdh.ymcdh.Dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/posts/{id}")
    public ResponseEntity<Posts> update(@PathVariable String id, @RequestBody Posts dto)
    {
        dto.setId(Long.parseLong(id));

        postService.save(dto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Posts> delete(@PathVariable String id)
    {
        Posts dto = new Posts();

        dto.setId(Long.parseLong(id));

        postService.delete(dto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}

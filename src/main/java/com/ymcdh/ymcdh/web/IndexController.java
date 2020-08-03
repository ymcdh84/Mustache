package com.ymcdh.ymcdh.web;

import com.ymcdh.ymcdh.Dto.Posts;
import com.ymcdh.ymcdh.Dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;


    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("posts", postService.findAllDesc());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {

        Posts entity = postService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("There is no Post... id = " + id));

        model.addAttribute("post", entity);

        return "posts-update";
    }

}

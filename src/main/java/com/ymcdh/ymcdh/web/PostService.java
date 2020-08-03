package com.ymcdh.ymcdh.web;

import com.ymcdh.ymcdh.Dto.Posts;
import com.ymcdh.ymcdh.Dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void insert(Posts user) {
        user.setId(Long.parseLong(postsRepository.getMaxId()) + 1);
        user.setModifiedDate(LocalDateTime.MAX);
        postsRepository.save(user);
    }
}

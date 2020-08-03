package com.ymcdh.ymcdh.web;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ymcdh.ymcdh.Dto.Posts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p From Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query(value = "SELECT NVL(MAX(ID),0) FROM POSTS", nativeQuery = true)
    String getMaxId();
}

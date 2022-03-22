package com.hunsblog.sounghun.contllor;

import com.hunsblog.sounghun.domain.Blog;
import com.hunsblog.sounghun.domain.BlogRepository;
import com.hunsblog.sounghun.domain.BlogRequestDto;
import com.hunsblog.sounghun.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @GetMapping("/api/blog")
    public List<Blog> getBlog() {
        LocalDateTime start = LocalDateTime.now().minusDays(7);
        LocalDateTime end = LocalDateTime.now();
        return blogRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    @PostMapping("/api/blog")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    @GetMapping("/api/blog/{id}")
    public Optional<Blog> getBlog(@PathVariable Long id) {
        return blogRepository.findById(id);
    }


    @PutMapping("/api/blog/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        blogService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/blog/{id}")
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }
}
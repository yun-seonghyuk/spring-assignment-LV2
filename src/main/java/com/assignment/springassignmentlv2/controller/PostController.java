package com.assignment.springassignmentlv2.controller;

import com.assignment.springassignmentlv2.dto.PostRequestDto;
import com.assignment.springassignmentlv2.dto.PostResponseDto;
import com.assignment.springassignmentlv2.entity.User;
import com.assignment.springassignmentlv2.security.UserDetailsImpl;
import com.assignment.springassignmentlv2.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return postService.createPost(postRequestDto, user);
    }

    @GetMapping("/post")
    public List<PostResponseDto> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/post/{id}")
    public PostResponseDto getPost(@PathVariable Long id){
        return postService.getPost(id);
    }

    @PutMapping("/post/update")
    public PostResponseDto updatePost(@RequestParam Long id, @RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        return postService.updatePost(id, postRequestDto, user);
    }

    @DeleteMapping("/post/delete")
    public PostResponseDto deletePost(@RequestParam Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return postService.deletePost(id,user);

    }
}

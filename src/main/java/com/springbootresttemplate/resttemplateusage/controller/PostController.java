package com.springbootresttemplate.resttemplateusage.controller;

import com.springbootresttemplate.resttemplateusage.model.Post;
import com.springbootresttemplate.resttemplateusage.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * PostRestController expose our data to client side.
 *
 * @author Kayhan Öztürk
 * @version  0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Post>> findAllPosts() {
        List<Post> postDetails = postService.findAllPost();
        return new ResponseEntity<>(postDetails, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable("id") int id) {
        Post posts = postService.findPostById(id);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePostById(@PathVariable("id") int id,
                                               @Valid @RequestBody Post post) {
        Post updatedPost = postService.updatePostById(id, post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }
}
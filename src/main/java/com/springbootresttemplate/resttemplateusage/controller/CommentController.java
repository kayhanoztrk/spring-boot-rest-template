package com.springbootresttemplate.resttemplateusage.controller;

import com.springbootresttemplate.resttemplateusage.model.Comment;
import com.springbootresttemplate.resttemplateusage.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * CommentRestController expose our data to client side.
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Comment>> findAllPosts() {
        List<Comment> commentDetails = commentService.findAllComment();
        return new ResponseEntity<>(commentDetails, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Comment> findCommentById(@PathVariable("id") int id) {
        Comment comment = commentService.findCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Comment> updatePostById(@PathVariable("id") int id,
                                                  @Valid @RequestBody Comment comment) {
        Comment updatedComment = commentService.updateCommentById(id, comment);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }
}
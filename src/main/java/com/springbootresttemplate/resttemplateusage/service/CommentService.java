package com.springbootresttemplate.resttemplateusage.service;

import com.springbootresttemplate.resttemplateusage.model.Comment;
import com.springbootresttemplate.resttemplateusage.model.Post;

import java.util.List;

public interface CommentService {
    List<Comment> findAllComment();
    Comment findCommentById(int id);
    Comment updateCommentById(int id, Comment Comment);
}

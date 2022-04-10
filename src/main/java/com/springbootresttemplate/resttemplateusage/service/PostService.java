package com.springbootresttemplate.resttemplateusage.service;

import com.springbootresttemplate.resttemplateusage.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPost();
    Post findPostById(int id);
    Post updatePostById(int id, Post Post);
}

package com.springbootresttemplate.resttemplateusage.service.impl;

import com.springbootresttemplate.resttemplateusage.model.Comment;
import com.springbootresttemplate.resttemplateusage.model.Post;
import com.springbootresttemplate.resttemplateusage.service.CommentService;
import com.springbootresttemplate.resttemplateusage.util.UrlGenerator;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private HttpEntity<String> httpEntity;
    private final UrlGenerator urlGenerator;

    public CommentServiceImpl(RestTemplate restTemplate, HttpHeaders httpHeaders,
                              UrlGenerator urlGenerator){
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
        this.urlGenerator = urlGenerator;
    }

    @Override
    public List<Comment> findAllComment() {
        ResponseEntity<List> response = restTemplate.exchange(
                urlGenerator.getCommentsFindAllURL(),
                HttpMethod.GET, httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Comment findCommentById(int id) {
        String commentByIdURL = urlGenerator.getCommentFindByIdURL(id);
        ResponseEntity<Comment> response = restTemplate
                .exchange(commentByIdURL, HttpMethod.GET, httpEntity, Comment.class);
        return response.getBody();
    }

    @Override
    public Comment updateCommentById(int id, Comment comment) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        Map<String, String> param = new HashMap<String, String>();
        param.put("postId", comment.getPostId());
        param.put("id", comment.getId());
        param.put("name", comment.getName());
        param.put("email", comment.getEmail());
        param.put("body", comment.getBody());

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(param, httpHeaders);
        String postByIdURL = urlGenerator.getCommentFindByIdURL(id);

        ResponseEntity<Comment> response = restTemplate
                .exchange(postByIdURL, HttpMethod.PUT, httpEntity, Comment.class);
        return response.getBody();
    }
}

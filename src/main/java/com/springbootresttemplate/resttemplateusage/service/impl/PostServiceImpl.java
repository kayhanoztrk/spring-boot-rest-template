package com.springbootresttemplate.resttemplateusage.service.impl;

import com.springbootresttemplate.resttemplateusage.model.Post;
import com.springbootresttemplate.resttemplateusage.service.PostService;
import com.springbootresttemplate.resttemplateusage.util.UrlGenerator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private HttpEntity<String> httpEntity;
    private final UrlGenerator urlGenerator;

    public PostServiceImpl(RestTemplate restTemplate, HttpHeaders httpHeaders,
                           UrlGenerator urlGenerator) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
        this.urlGenerator = urlGenerator;
    }

    @Override
    public List<Post> findAllPost() {
        ResponseEntity<List> response = restTemplate.exchange(
                urlGenerator.getPostsFindAllURL(),
                HttpMethod.GET, httpEntity, List.class);
        return response.getBody();
    }

    @Override
    public Post findPostById(int id) {
        String postByIdURL = urlGenerator.getPostFindByIdURL(id);
        ResponseEntity<Post> response = restTemplate
                .exchange(postByIdURL, HttpMethod.GET, httpEntity, Post.class);
        return response.getBody();
    }

    @Override
    public Post updatePostById(int id, Post post) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", post.getId());
        param.put("title", post.getTitle());
        param.put("body", post.getBody());

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(param, httpHeaders);
        String postByIdURL = urlGenerator.getPostFindByIdURL(id);

        ResponseEntity<Post> response = restTemplate
                .exchange(postByIdURL, HttpMethod.PUT, httpEntity, Post.class);
        return response.getBody();
    }
}

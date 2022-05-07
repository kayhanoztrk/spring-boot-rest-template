package com.springbootresttemplate.resttemplateusage.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlGenerator {

    @Value("${thirdparty.endpoint.post.url}")
    private String postsURL;

    @Value("${thirdparty.endpoint.comment.url}")
    private String commentsURL;

    public String getPostFindByIdURL(int id){
        StringBuilder sb = new StringBuilder();
        sb.append(postsURL);
        sb.append(id);
        return sb.toString();
    }

    public String getPostsFindAllURL(){
        return postsURL;
    }

    public String getCommentFindByIdURL(int id){
        StringBuilder sb = new StringBuilder();
        sb.append(commentsURL);
        sb.append(id);
        return sb.toString();
    }

    public String getCommentsFindAllURL(){ return commentsURL;}
}
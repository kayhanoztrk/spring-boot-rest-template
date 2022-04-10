package com.springbootresttemplate.resttemplateusage.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlGenerator {

    @Value("${thirdparty.endpoint.post.url}")
    private String postsURL;

    public String getPostFindByIdURL(int id){
        StringBuilder sb = new StringBuilder();
        sb.append(postsURL);
        sb.append(id);
        return sb.toString();
    }

    public String getPostsFindAllURL(){
        return postsURL;
    }
}
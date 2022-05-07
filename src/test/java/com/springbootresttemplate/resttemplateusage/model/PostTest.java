package com.springbootresttemplate.resttemplateusage.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link Post}
 *
 * @author Kayhan Ozturk
 * @version 0.1
 * @since   0.1
 */
public class PostTest {

    private Post post;
    @Before
    public void setUp(){
        post = new Post();

        post.setId("id");
        post.setTitle("title");
        post.setUserId("userId");
        post.setBody("body");
    }

    @Test
    public void testGetter(){
        Assert.assertNotNull(post);

        Assert.assertNotNull(post.getId());
        Assert.assertNotNull(post.getTitle());
        Assert.assertNotNull(post.getBody());
        Assert.assertNotNull(post.getUserId());
    }
}

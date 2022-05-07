package com.springbootresttemplate.resttemplateusage.service.impl;

import com.springbootresttemplate.resttemplateusage.model.Post;
import com.springbootresttemplate.resttemplateusage.service.PostService;
import com.springbootresttemplate.resttemplateusage.service.impl.PostServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit Test for {@link PostServiceImpl}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class PostServiceImplTest {
    private PostServiceImpl postService;
    private Post post;

    @Before
    public void setUp() {
        postService = mock(PostServiceImpl.class);

        post = new Post();
        post.setId("id");
        post.setUserId("userId");
        post.setTitle("title");
        post.setBody("body");

        when(postService.findAllPost()).thenReturn(Arrays.asList(post));
        when(postService.findPostById(1)).thenReturn(post);
        when(postService.updatePostById(1, post)).thenReturn(post);
    }

    @Test
    public void testFindAllPost() {
        List<Post> postList = postService.findAllPost();
        Assert.assertNotNull(postList);
    }

    @Test
    public void testFindPostById() {
        Post post = postService.findPostById(1);
        Assert.assertNotNull(post);
    }

    @Test
    public void testUpdatePostById() {
        Post postCon = new Post();
        postCon.setId("id");
        postCon.setUserId("userId");
        postCon.setTitle("title");
        postCon.setBody("body");

        Post post = postService.updatePostById(1, postCon);
        Assert.assertNotNull(post);
    }
}

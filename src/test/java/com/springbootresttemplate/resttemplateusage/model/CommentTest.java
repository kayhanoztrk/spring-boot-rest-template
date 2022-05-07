package com.springbootresttemplate.resttemplateusage.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * UnitTest for {@link Comment}
 *
 * @author Kayhan Ozturk
 * @version 0.1
 * @since 0.1
 */
public class CommentTest {

    private Comment comment;

    @Before
    public void setUp() {
        comment = new Comment();

        comment.setId("id");
        comment.setName("name");
        comment.setEmail("email");
        comment.setPostId("postId");
        comment.setBody("bodyField");
    }

    @Test
    public void testGetter() {
        Assert.assertNotNull(comment);

        Assert.assertNotNull(comment.getId());
        Assert.assertNotNull(comment.getPostId());
        Assert.assertNotNull(comment.getName());
        Assert.assertNotNull(comment.getEmail());
        Assert.assertNotNull(comment.getBody());
    }
}

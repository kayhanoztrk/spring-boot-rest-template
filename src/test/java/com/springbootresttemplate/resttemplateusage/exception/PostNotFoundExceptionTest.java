package com.springbootresttemplate.resttemplateusage.exception;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link PostNotFoundException}
 *
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public class PostNotFoundExceptionTest {
    private PostNotFoundException postNotFoundException;

    @Before
    public void setUp() {
        postNotFoundException = new PostNotFoundException("message");
        Assert.assertNotNull(postNotFoundException);
    }

    @Test
    public void constructorTest(){
        postNotFoundException = new PostNotFoundException("message");
        Assert.assertNotNull(postNotFoundException);
    }
}

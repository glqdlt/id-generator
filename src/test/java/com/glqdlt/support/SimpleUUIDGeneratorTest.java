package com.glqdlt.support;

import org.junit.Assert;
import org.junit.Test;

public class SimpleUUIDGeneratorTest {

    @Test
    public void name() {
        SimpleUUIDGenerator simpleUUIDGenerator = new SimpleUUIDGenerator();
        String id = simpleUUIDGenerator.generate();
        Assert.assertTrue(simpleUUIDGenerator.verify(id));
    }
}
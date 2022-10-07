package com.glqdlt.support;

/**
 * @author glqdlt
 */
public interface IdGenerator {
    String generate();

    Boolean verify(String id);
}

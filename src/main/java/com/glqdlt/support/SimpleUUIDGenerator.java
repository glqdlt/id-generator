package com.glqdlt.support;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author glqdlt
 */
public class SimpleUUIDGenerator implements IdGenerator {

    public static final String ID_REGEX = "[0-9a-zA-Z]{32,32}";
    public static final Pattern PATTERN = Pattern.compile(SimpleUUIDGenerator.ID_REGEX);

    public String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public Boolean verify(String id) {
        return PATTERN.matcher(id).matches();
    }
}

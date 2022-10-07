package com.glqdlt.support;

/**
 * @author glqdlt
 */
public class SimpleIdBucket implements IdBucket {

    private IdGenerator idGenerator = new SimpleUUIDGenerator();

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public String getId() {
        return idGenerator.generate();
    }
}

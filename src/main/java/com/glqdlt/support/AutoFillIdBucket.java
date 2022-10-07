package com.glqdlt.support;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author glqdlt
 */
public class AutoFillIdBucket extends SimpleIdBucket {

    private final Map<Boolean, Queue<String>> storage = new HashMap<>();
    private Boolean cursor = true;
    private final ExecutorService executors = Executors.newFixedThreadPool(1);
    private Integer limit = 2000;
    private Integer threshold = limit / 2;

    private void changeLimit(Integer limit) {
        this.limit = limit;
        this.threshold = limit / 2;
    }

    public AutoFillIdBucket() {
        fill(true);
        fill(false);
        watcher();
    }

    public AutoFillIdBucket(Integer limit) {
        changeLimit(limit);
        fill(true);
        fill(false);
        watcher();
    }

    private void fill(Boolean cursor) {
        IdGenerator idGenerator = getIdGenerator();
        Queue<String> entry = new LinkedList<>();
        int i = 0;
        while (i < limit) {
            entry.add(idGenerator.generate());
            i++;
        }
        storage.put(cursor, entry);
    }

    @Override
    public String getId() {
        return Optional.ofNullable(storage.get(cursor).poll())
                .orElseGet(() -> {
                    fill(cursor);
                    return storage.get(cursor).poll();
                });
    }

    private void watcher() {
        executors.submit(() -> {

            while (true) {
                boolean currentCursor = this.cursor;
                int currentIdSize = this.storage.get(currentCursor).size();
                if (currentIdSize < this.threshold) {
                    this.cursor = !currentCursor;
                    this.fill(currentCursor);
                }
                Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            }
        });
    }


}

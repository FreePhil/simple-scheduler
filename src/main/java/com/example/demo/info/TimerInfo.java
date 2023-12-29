package com.example.demo.info;

public class TimerInfo {
    private int totalFileCount;
    private boolean runForever;
    private long repeatIntervalMs;
    private long initialOffsetMs;
    private String callbackData;

    public int getTotalFileCount() {
        return totalFileCount;
    }

    public void setTotalFireCount(int totalFileCount) {
        this.totalFileCount = totalFileCount;
    }

    public boolean isRunForever() {
        return runForever;
    }

    public void setRunForever(boolean runForever) {
        this.runForever = runForever;
    }

    public long getRepeatIntervalMs() {
        return repeatIntervalMs;
    }

    public void setRepeatIntervalMs(long repeatIntervalMs) {
        this.repeatIntervalMs = repeatIntervalMs;
    }

    public long getInitialOffsetMs() {
        return initialOffsetMs;
    }

    public void setInitialOffsetMs(long initialOffsetMs) {
        this.initialOffsetMs = initialOffsetMs;
    }

    public String getCallbackData() {
        return callbackData;
    }

    public void setCallbackData(String callbackData) {
        this.callbackData = callbackData;
    }
}

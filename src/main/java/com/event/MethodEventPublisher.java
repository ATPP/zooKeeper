package com.event;

import java.util.ArrayList;
import java.util.List;

public class MethodEventPublisher {

    private List<MethodExecutionEventListener> listeners = new ArrayList<>();

    public void methodToMonitor() {
        MethodExecutionEvent executionEvent = new MethodExecutionEvent(this, "methodToMonitor");
        publishEvent("1", executionEvent);
        //....执行实际方法
        System.out.println("执行实际方法");
        publishEvent("2", executionEvent);
    }

    protected void publishEvent(String status, MethodExecutionEvent executionEvent) {
        List<MethodExecutionEventListener> copyListener = new ArrayList<>(listeners);
        for (MethodExecutionEventListener listener : copyListener) {
            if (status.equals("1")) {
                listener.OnMethodBengin(executionEvent);
            } else {
                listener.OnMethodEnd(executionEvent);
            }
        }
    }

    public void addListener(MethodExecutionEventListener listener){
        listeners.add(listener);
    }

    public void removeListener(MethodExecutionEventListener listener){
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    public void removeAllListener(){
        listeners.clear();
    }

    public static void main(String[] args) {
        MethodEventPublisher publisher = new MethodEventPublisher();
        publisher.addListener(new SimpleMethodExecutionEventListener());
        publisher.methodToMonitor();
    }
}

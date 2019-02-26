package com.event;

public class SimpleMethodExecutionEventListener implements MethodExecutionEventListener {
    @Override
    public void OnMethodBengin(MethodExecutionEvent executionEvent) {
        String methodName = executionEvent.getMethodName();
        System.out.println("方法执行前:" + methodName);
    }

    @Override
    public void OnMethodEnd(MethodExecutionEvent executionEvent) {
        String methodName = executionEvent.getMethodName();
        System.out.println("方法执行后：" + methodName);
    }
}

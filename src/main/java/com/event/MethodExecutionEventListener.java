package com.event;

import java.util.EventListener;

public interface MethodExecutionEventListener extends EventListener {

    void OnMethodBengin(MethodExecutionEvent executionEvent);

    void OnMethodEnd(MethodExecutionEvent executionEvent);
}

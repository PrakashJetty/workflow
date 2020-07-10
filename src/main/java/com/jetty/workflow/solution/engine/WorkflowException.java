package com.jetty.workflow.solution.engine;

public class WorkflowException extends Exception {

    public WorkflowException() {
    }

    public WorkflowException(String s) {
        super(s);
    }

    public WorkflowException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WorkflowException(Throwable throwable) {
        super(throwable);
    }

    public WorkflowException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}

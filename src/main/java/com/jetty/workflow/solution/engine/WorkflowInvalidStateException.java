package com.jetty.workflow.solution.engine;

public class WorkflowInvalidStateException extends Exception {

    public WorkflowInvalidStateException() {
    }

    public WorkflowInvalidStateException(String message) {
        super(message);
    }

    public WorkflowInvalidStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkflowInvalidStateException(Throwable cause) {
        super(cause);
    }

    public WorkflowInvalidStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

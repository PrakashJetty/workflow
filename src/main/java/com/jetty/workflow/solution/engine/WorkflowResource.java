package com.jetty.workflow.solution.engine;

public interface WorkflowResource {

    Object getUniqueId();

    void setNextStatus(String status);

    String getCurrentStatus();
}

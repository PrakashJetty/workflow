package com.jetty.workflow.solution;

import java.io.Serializable;

/**
 * Created by prakashjetty on 11/6/18.
 */
public class WorkflowRole implements Serializable {

    private String name;

    public WorkflowRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

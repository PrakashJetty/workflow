package com.jetty.workflow.solution;

import java.io.Serializable;
import java.util.List;

/**
 * Created by prakashjetty on 11/6/18.
 */
public class WorkflowUser implements Serializable {

    public WorkflowUser(List<WorkflowRole> role) {
        this.role = role;
    }

    public List<WorkflowRole> getRole() {
        return role;
    }

    public void setRole(List<WorkflowRole> role) {
        this.role = role;
    }

    private List<WorkflowRole> role;


}

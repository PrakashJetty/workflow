package com.jetty.workflow.solution;

import com.jetty.workflow.solution.engine.WorkflowResource;

import java.io.Serializable;

/**
 * Created by prakashjetty on 1/27/18.
 */
public abstract class WorkFlowInput implements Serializable {

    protected boolean isProcessedSuccessfully;
    protected boolean isProcessedPartially;
    protected String currentAction;
    protected String status;
    protected WorkflowResource workflowResource;

    public WorkFlowInput() {
    }

    public WorkFlowInput(WorkflowResource workflowResource) {
        this.workflowResource = workflowResource;
    }

    public boolean isProcessedSuccessfully() {
        return isProcessedSuccessfully;
    }

    public void setProcessedSuccessfully(boolean processedSuccessfully) {
        isProcessedSuccessfully = processedSuccessfully;
    }

    public String getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(String currentAction) {
        this.currentAction = currentAction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isProcessedPartially() {
        return isProcessedPartially;
    }

    public void setProcessedPartially(boolean processedPartially) {
        isProcessedPartially = processedPartially;
    }

    public WorkflowResource getWorkflowResource() {
        return workflowResource;
    }

    public void setWorkflowResource(WorkflowResource workflowResource) {
        this.workflowResource = workflowResource;
    }
}

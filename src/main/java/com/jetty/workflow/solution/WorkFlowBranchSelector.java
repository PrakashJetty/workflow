package com.jetty.workflow.solution;

/**
 * Created by prakashjetty on 1/28/18.
 */
public abstract class WorkFlowBranchSelector extends WorkFlowComponent {

    private WorkFlowInput workFlowInput;

    public WorkFlowInput getWorkFlowInput() {
        return workFlowInput;
    }

    public void setWorkFlowInput(WorkFlowInput workFlowInput) {
        this.workFlowInput = workFlowInput;
    }


}

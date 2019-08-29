package com.jetty.workflow;

/**
 * Created by prakashjetty on 1/28/18.
 */
public class WorkFlowBranchSelector extends WorkFlowComponent {

    private WorkFlowInput workFlowInput;

    public WorkFlowInput getWorkFlowInput() {
        return workFlowInput;
    }

    public void setWorkFlowInput(WorkFlowInput workFlowInput) {
        this.workFlowInput = workFlowInput;
    }


}

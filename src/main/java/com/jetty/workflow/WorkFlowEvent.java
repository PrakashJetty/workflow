package com.jetty.workflow;

/**
 * Created by prakashjetty on 1/27/18.
 */
public class WorkFlowEvent extends WorkFlowComponent {

    private WorkFlowInput workFlowInput;

    public WorkFlowInput getWorkFlowInput() {
        return workFlowInput;
    }

    public void setWorkFlowInput(WorkFlowInput workFlowInput) {
        this.workFlowInput = workFlowInput;
    }

    @Override
    public void process(WorkFlowInput workFlowInput) {

    }
}

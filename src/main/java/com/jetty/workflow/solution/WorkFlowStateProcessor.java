package com.jetty.workflow.solution;

/**
 * Created by prakashjetty on 1/28/18.
 */
public class WorkFlowStateProcessor extends WorkFlowComponent {
    public WorkFlowInput getWorkFlowInput() {
        return workFlowInput;
    }

    public void setWorkFlowInput(WorkFlowInput workFlowInput) {
        this.workFlowInput = workFlowInput;
    }

    private WorkFlowInput workFlowInput;


    @Override
    public void process(WorkFlowInput workFlowInput) {

    }
}

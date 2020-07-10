package com.jetty.workflow.solution;

/**
 * Created by prakashjetty on 11/5/18.
 */
public class WorkflowStartEvent extends WorkFlowComponent {


    @Override
    public void process(WorkFlowInput workFlowInput) throws Exception   {
        workFlowInput.getWorkflowResource().setNextStatus(this.getWorkflowStatus().getStatus());
    }
}

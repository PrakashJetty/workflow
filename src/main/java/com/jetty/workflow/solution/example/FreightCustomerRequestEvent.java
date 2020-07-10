package com.jetty.workflow.solution.example;

import com.jetty.workflow.solution.WorkFlowInput;
import com.jetty.workflow.solution.WorkflowStartEvent;

/**
 * Created by prakashjetty on 11/6/18.
 */
public class FreightCustomerRequestEvent extends WorkflowStartEvent {

    private String emailContent;


    @Override
    public void process(WorkFlowInput workFlowInput) throws Exception   {
        super.process(workFlowInput);
    }
}

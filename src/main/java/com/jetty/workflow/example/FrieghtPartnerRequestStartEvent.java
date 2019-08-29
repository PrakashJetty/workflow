package com.jetty.workflow.example;

import com.jetty.workflow.WorkFlowInput;
import com.jetty.workflow.WorkflowStartEvent;

/**
 * Created by prakashjetty on 11/6/18.
 */
public class FrieghtPartnerRequestStartEvent extends WorkflowStartEvent {

    private String emailContent;

    @Override
    public void process(WorkFlowInput workFlowInput) {
        super.process(workFlowInput);
    }
}

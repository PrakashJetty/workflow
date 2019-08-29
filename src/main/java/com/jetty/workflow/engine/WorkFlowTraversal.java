package com.jetty.workflow.engine;

/**
 * Created by prakashjetty on 11/8/18.
 */
public class WorkFlowTraversal {


    public WorkFlowNode traverse(WorkFlowNode workFlowNode) {
        return workFlowNode.getOut().stream().filter(w -> w.getCondition().test(workFlowNode.getWorkFlowInput())).findFirst().get().getOut();
    }

}

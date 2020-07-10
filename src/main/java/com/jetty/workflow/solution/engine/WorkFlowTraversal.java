package com.jetty.workflow.solution.engine;

import java.util.Optional;

/**
 * Created by prakashjetty on 11/8/18.
 */
public class WorkFlowTraversal {


    public static Optional<WorkFlowEdge>  getMatchingOut(WorkFlowNode workFlowNode) {
        return workFlowNode.getOut().stream().filter(w -> w.getCondition().test(workFlowNode.getWorkFlowInput())).findFirst();
    }

}

package com.jetty.workflow.solution.configure;


import com.jetty.workflow.solution.WorkflowStartEvent;
import com.jetty.workflow.solution.engine.WorkFlowNode;

/**
 * Created by prakashjetty on 1/28/18.
 */
public class WorkFlowConfigurer {


    public static WorkFlowNode addStartNode(WorkflowStartEvent workFlowStartEvent) {
        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setStartNode(true);
//        workFlowNode.setWorkFlowNodeType(WorkFlowNodeType.START_EVENT);
        workFlowNode.setWorkFlowComponent(workFlowStartEvent);
        return workFlowNode;
    }

//    public static WorkFlowNode addWorkflowStateProcessor(WorkFlowStateProcessor workFlowStateProcessor) {
//        WorkFlowNode workFlowNode = new WorkFlowNode();
////        workFlowNode.setWorkFlowNodeType(WorkFlowNodeType.STATE_PROCESSOR);
//        workFlowNode.setWorkFlowComponent(workFlowStateProcessor);
//        return workFlowNode;
//    }
//
//    public static WorkFlowNode addBranchSelector(WorkflowGatewayConvergentComponent workflowGatewayConvergentComponent) {
//        WorkFlowNode workFlowNode = new WorkFlowNode();
////        workFlowNode.setWorkFlowNodeType(WorkFlowNodeType.GATEWAY_CONVERGE);
//        workFlowNode.setWorkFlowComponent(workflowGatewayConvergentComponent);
//        return workFlowNode;
//    }
}

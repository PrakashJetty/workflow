package com.jetty.workflow.engine;

import com.jetty.workflow.WorkFlowInput;
import com.jetty.workflow.WorkflowUser;

import java.util.UUID;

/**
 * Created by prakashjetty on 11/9/18.
 */
public class WorkFlowGraphProcessor {


    public void startWorkFlow(WorkFlowInput workFlowInput, WorkflowUser workflowUser,
                              WorkFlowGraph workFlowGraph, String startEventType) throws WorkflowUnauthorizdException {
        WorkFlowNode startNode = workFlowGraph.getStartEventMap().get(startEventType);
        if (startNode.getActors().stream().anyMatch(a -> a.getRole().equals(workflowUser.getRole()))) {
            startNode.setWorkFlowInput(workFlowInput);
            startNode.getWorkFlowComponent().process(workFlowInput);
            workFlowGraph.setCurrentNode(startNode.getOut().iterator().next().getOut());
            WorkFlowInstanceMap.getWorkFlowNodeMap().put(UUID.randomUUID(), workFlowGraph);
        } else {
            throw new WorkflowUnauthorizdException(workflowUser.getRole() + " is not the right role to start workflow");
        }
    }


    public void processWorkFlow(WorkFlowInput workFlowInput, WorkflowUser workflowUser, UUID workFlowId) throws WorkflowUnauthorizdException {
        WorkFlowGraph workFlowGraph = WorkFlowInstanceMap.getWorkFlowNodeMap().get(workFlowId);
        WorkFlowNode node = workFlowGraph.getCurrentNode();
        if (node.getActors().stream().anyMatch(a -> a.getRole().equals(workflowUser.getRole()))) {
            node.setWorkFlowInput(workFlowInput);
            node.getWorkFlowComponent().process(workFlowInput);
            workFlowGraph.setCurrentNode(node.getOut().iterator().next().getOut());
        } else {
            throw new WorkflowUnauthorizdException(workflowUser.getRole() + " is not the right role to start workflow");
        }
    }


}

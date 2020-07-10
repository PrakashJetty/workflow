package com.jetty.workflow.solution.engine;

import com.jetty.workflow.solution.WorkFlowInput;
import com.jetty.workflow.solution.WorkflowEndEvent;
import com.jetty.workflow.solution.WorkflowUser;


import java.util.Optional;

/**
 * Created by prakashjetty on 11/9/18.
 */

public class WorkFlowGraphProcessor {


    private static boolean checkRole(WorkflowUser workflowUser, WorkFlowNode startNode) {
        return workflowUser.getRole().stream().anyMatch( r -> startNode.getActors().stream().anyMatch(a -> a.getRole().stream().anyMatch(ri -> ri.getName().equals(r.getName()))));
    }

    public static void startWorkFlow(WorkFlowInput workFlowInput, WorkflowUser workflowUser,
                              WorkFlowGraph workFlowGraph, String startEventType,
                                     StorageInterface storageInterface, WorkflowResource resource ) throws WorkflowException {

        try {
            storageInterface.store(resource, workFlowGraph);
            WorkFlowNode startNode = storageInterface.getObjectgraphById(resource).getStartEventMap().get(startEventType);
            if (checkRole(workflowUser, startNode)) {
                startNode.setWorkFlowInput(workFlowInput);

//            Optional<WorkFlowEdge> optionalWorkFlowEdge =  WorkFlowTraversal.getMatchingOut(startNode);
                startNode.getWorkFlowComponent().process(workFlowInput);
                workFlowGraph.setCurrentNode(startNode);
//            optionalWorkFlowEdge
//                    .ifPresent((workFlowEdge) -> );
//            optionalWorkFlowEdge.orElseThrow(() -> new WorkflowInvalidStateException("Not valid action"));
                startNode.setWorkFlowInput(null);
                storageInterface.store(resource, workFlowGraph);
            } else {
                throw new WorkflowUnauthorizdException(workflowUser.getRole() + " is not the right role to start workflow");
            }
        } catch (Exception ex) {
            throw new WorkflowException(ex);
        }
    }


    public static void processWorkFlow(WorkFlowInput workFlowInput, WorkflowUser workflowUser,
                                       StorageInterface storageInterface, WorkflowResource resource) throws WorkflowException {
        try {
        WorkFlowGraph workFlowGraph = storageInterface.getObjectgraphById(resource);
        WorkFlowNode node = workFlowGraph.getCurrentNode();

       node.setWorkFlowInput(workFlowInput);
       Optional<WorkFlowEdge> optionalWorkFlowEdge =  WorkFlowTraversal.getMatchingOut(node);

        WorkFlowNode currentNode =  optionalWorkFlowEdge.orElseThrow(() -> new WorkflowInvalidStateException("Not valid action")).getOut();


        if (checkRole(workflowUser, currentNode)) {
            currentNode.getWorkFlowComponent().process(workFlowInput);
            if (currentNode.getWorkFlowComponent() instanceof WorkflowEndEvent) {
                storageInterface.remove(resource);
                return;
            }

            workFlowGraph.setCurrentNode(currentNode);

            node.setWorkFlowInput(null);

            storageInterface.store(resource, workFlowGraph);
        } else {
            throw new WorkflowUnauthorizdException(workflowUser.getRole() + " is not the right role to process this step of workflow");
        }
        } catch (Exception ex) {
            throw new WorkflowException(ex);
        }
    }


}

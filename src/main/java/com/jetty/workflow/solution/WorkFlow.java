package com.jetty.workflow.solution;

import com.jetty.workflow.solution.engine.PredicateSerializable;
import com.jetty.workflow.solution.engine.WorkFlowEdge;
import com.jetty.workflow.solution.engine.WorkFlowNode;

import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by prakashjetty on 1/27/18.
 */
public class WorkFlow {


    private WorkFlowNode currentNode;

    private List<WorkFlowNode> stratNodes;

    private Queue<WorkFlowNode> branchedAt = new LinkedBlockingQueue<>();

//    public List<WorkFlowNode> addStartEvents(Set<WorkflowStartEvent> workflowStartEvent) {
//        return workflowStartEvent.stream().map(wse -> WorkFlowConfigurer.addStartNode(wse)).collect(Collectors.toList());
////        return this;
//    }

    public WorkFlowNode addStartEvent(WorkflowStartEvent workflowStartEvent, WorkflowStatus nextStatus) {
        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setStartNode(true);
        workFlowNode.setWorkFlowComponent(workflowStartEvent);
        workflowStartEvent.setWorkflowStatus(nextStatus);
        workFlowNode.setActors(workflowStartEvent.getActors());
        this.setCurrentNode(workFlowNode);
//        this.stratNodes.add(workFlowNode);
        return workFlowNode;
//        return this;
    }

//    public WorkFlow addBranchSelector(WorkFlowBranchSelector workflowBranchSelector) {
//        if (this.getCurrentNode().getOut() == null) {
//            this.getCurrentNode().setOut(new HashSet<WorkFlowEdge>());
//        }
//        WorkFlowNode workFlowNode = WorkFlowConfigurer.addBranchSelector(workflowBranchSelector);
//        WorkFlowEdge edge = new WorkFlowEdge();
//        edge.setOut(workFlowNode);
//        this.getCurrentNode().getOut().add(edge);
//        this.setCurrentNode(workFlowNode);
//        return this;
//    }
//
//    public WorkFlow addWorkflowStateProcessor(WorkFlowStateProcessor workFlowStateProcessor) {
//        if (this.getCurrentNode().getOut() == null) {
//            this.getCurrentNode().setOut(new HashSet<>());
//        }
//        WorkFlowNode workFlowNode = WorkFlowConfigurer.addWorkflowStateProcessor(workFlowStateProcessor);
//        WorkFlowEdge edge = new WorkFlowEdge();
//        edge.setOut(workFlowNode);
//        this.getCurrentNode().getOut().add(edge);
//        this.setCurrentNode(workFlowNode);
//        return this;
//    }

    public WorkFlow addBranch(WorkFlowComponent workFlowComponent, WorkflowStatus nextStatus, PredicateSerializable condition) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        if (this.getCurrentNode().getOut() == null)
            this.getCurrentNode().setOut(new HashSet<>());
        workFlowComponent.setWorkflowStatus(nextStatus);
        workFlowNode.setWorkFlowComponent(workFlowComponent);
        workFlowNode.setActors(workFlowComponent.getActors());
        workFlowNode.setWorkflowOrthogonalComponents(workFlowComponent.getWorkflowOrthogonalComponents());
        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setCondition(condition);
        edge.setOut(workFlowNode);

        this.getCurrentNode().getOut().add(edge);
        this.setCurrentNode(workFlowNode);

//        // branchedAt.add(this.getCurrentNode());
//        if (workFlowComponent instanceof WorkFlowBranchSelector) {
//            addBranchSelector((WorkFlowBranchSelector) workFlowComponent);
//        } else {
//            addWorkflowStateProcessor((WorkFlowStateProcessor) workFlowComponent);
//        }
        return this;
    }

    public WorkFlow startBranch(WorkFlowComponent workFlowComponent, WorkflowStatus nextStatus, PredicateSerializable condition) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowComponent.setWorkflowStatus(nextStatus);
        workFlowNode.setWorkFlowComponent(workFlowComponent);
        workFlowNode.setActors(workFlowComponent.getActors());
        workFlowNode.setWorkflowOrthogonalComponents(workFlowComponent.getWorkflowOrthogonalComponents());
        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setCondition(condition);
        edge.setOut(workFlowNode);

        if (this.getCurrentNode() != null) {
            if (this.getCurrentNode().getOut() == null) {
                this.getCurrentNode().setOut(new HashSet());
            }
            this.getCurrentNode().getOut().add(edge);
            branchedAt.add(this.getCurrentNode());

        } else {
            this.stratNodes.stream().forEach(sn -> {
                if (sn.getOut() == null) {
                    sn.setOut(new HashSet());
                }
                sn.getOut().add(edge);
            });
        }
        this.setCurrentNode(workFlowNode);


//        // branchedAt.add(this.getCurrentNode());
//        if (workFlowComponent instanceof WorkFlowBranchSelector) {
//            addBranchSelector((WorkFlowBranchSelector) workFlowComponent);
//        } else {
//            addWorkflowStateProcessor((WorkFlowStateProcessor) workFlowComponent);
//        }
        return this;
    }


    public WorkFlow endBranch() {
        //branchedAt.remove();
        this.setCurrentNode(branchedAt.poll());
        return this;
    }


//    public WorkFlow addEndEvent(WorkFlowEvent workFlowEvent) {
//        this.currentNode.set
//        return this;
//    }


    public WorkFlow addEndEvent(WorkflowEndEvent workflowEndEvent, WorkflowStatus endStatus) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workflowEndEvent.setWorkflowStatus(endStatus);
        workFlowNode.setWorkFlowComponent(workflowEndEvent);
        workFlowNode.setActors(workflowEndEvent.getActors());
        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setOut(workFlowNode);
        if (this.getCurrentNode().getOut() == null) {
            this.getCurrentNode().setOut(new HashSet<>());
        }
        this.getCurrentNode().getOut().add(edge);
        edge.setIn(workFlowNode);

//        // branchedAt.add(this.getCurrentNode());
//        if (workFlowComponent instanceof WorkFlowBranchSelector) {
//            addBranchSelector((WorkFlowBranchSelector) workFlowComponent);
//        } else {
//            addWorkflowStateProcessor((WorkFlowStateProcessor) workFlowComponent);
//        }
        return this;

    }

    public WorkFlowNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(WorkFlowNode currentNode) {
        this.currentNode = currentNode;
    }

    public Queue<WorkFlowNode> getBranchedAt() {
        return branchedAt;
    }

    public void setBranchedAt(Queue<WorkFlowNode> branchedAt) {
        this.branchedAt = branchedAt;
    }

    public List<WorkFlowNode> getStratNodes() {
        return stratNodes;
    }

    public void setStratNodes(List<WorkFlowNode> stratNodes) {
        this.stratNodes = stratNodes;
    }
}

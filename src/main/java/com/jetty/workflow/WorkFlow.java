package com.jetty.workflow;

import com.jetty.workflow.configure.WorkFlowConfigurer;
import com.jetty.workflow.engine.WorkFlowEdge;
import com.jetty.workflow.engine.WorkFlowNode;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Predicate;

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

    public WorkFlowNode addStartEvent(WorkflowStartEvent workflowStartEvent) {
        return WorkFlowConfigurer.addStartNode(workflowStartEvent);
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

    public WorkFlow addBranch(WorkFlowComponent workFlowComponent, Predicate<WorkFlowInput> condition) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setWorkFlowComponent(workFlowComponent);
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

    public WorkFlow startBranch(WorkFlowComponent workFlowComponent, Predicate<WorkFlowInput> condition) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setWorkFlowComponent(workFlowComponent);
        workFlowNode.setWorkflowOrthogonalComponents(workFlowComponent.getWorkflowOrthogonalComponents());
        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setCondition(condition);
        edge.setOut(workFlowNode);

        if (this.getCurrentNode() != null) {
            this.getCurrentNode().getOut().add(edge);
            branchedAt.add(this.getCurrentNode());

        } else {
            this.stratNodes.stream().forEach(sn -> sn.getOut().add(edge));
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


    public WorkFlow addEndEvent(WorkflowEndEvent workflowEndEvent) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setWorkFlowComponent(workflowEndEvent);

        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setOut(workFlowNode);
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

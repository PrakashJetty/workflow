package com.jetty.workflow.engine;

import com.jetty.workflow.WorkFlowComponent;
import com.jetty.workflow.WorkFlowInput;
import com.jetty.workflow.WorkflowEndEvent;
import com.jetty.workflow.WorkflowOrthogonalComponent;
import com.jetty.workflow.WorkflowUser;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by prakashjetty on 1/28/18.
 */

public class WorkFlowNode {

    private boolean isStartNode;

    private WorkFlowNodeType workFlowNodeType;

    private Set<WorkFlowEdge> out;

    private Set<WorkFlowEdge> in;

    private WorkFlowInput workFlowInput;

    private WorkFlowComponent workFlowComponent;

    private List<WorkflowOrthogonalComponent> workflowOrthogonalComponents;

    private Set<WorkflowUser> actors;

    public boolean isStartNode() {
        return isStartNode;
    }

    public void setStartNode(boolean startNode) {
        isStartNode = startNode;
    }

    public Set<WorkFlowEdge> getOut() {
        return out;
    }

    public void setOut(Set<WorkFlowEdge> out) {
        this.out = out;
    }

    public Set<WorkFlowEdge> getIn() {
        return in;
    }

    public void setIn(Set<WorkFlowEdge> in) {
        this.in = in;
    }

    public WorkFlowInput getWorkFlowInput() {
        return workFlowInput;
    }

    public void setWorkFlowInput(WorkFlowInput workFlowInput) {
        this.workFlowInput = workFlowInput;
    }

    public WorkFlowNodeType getWorkFlowNodeType() {
        return workFlowNodeType;
    }

    public void setWorkFlowNodeType(WorkFlowNodeType workFlowNodeType) {
        this.workFlowNodeType = workFlowNodeType;
    }

    public WorkFlowComponent getWorkFlowComponent() {
        return workFlowComponent;
    }

    public void setWorkFlowComponent(WorkFlowComponent workFlowComponent) {
        this.workFlowComponent = workFlowComponent;
    }

    public Set<WorkflowUser> getActors() {
        return actors;
    }

    public void setActors(Set<WorkflowUser> actors) {
        this.actors = actors;
    }

    public List<WorkflowOrthogonalComponent> getWorkflowOrthogonalComponents() {
        return workflowOrthogonalComponents;
    }

    public void setWorkflowOrthogonalComponents(List<WorkflowOrthogonalComponent> workflowOrthogonalComponents) {
        this.workflowOrthogonalComponents = workflowOrthogonalComponents;
    }

    public WorkFlowNode startBranch(WorkFlowComponent workFlowComponent, Predicate<WorkFlowInput> condition) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setWorkFlowComponent(workFlowComponent);
        workFlowNode.setWorkflowOrthogonalComponents(workFlowComponent.getWorkflowOrthogonalComponents());
        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setCondition(condition);
        edge.setOut(workFlowNode);
        this.getOut().add(edge);
        return workFlowNode;
    }

    public WorkFlowNode addBranch(WorkFlowComponent workFlowComponent, Predicate<WorkFlowInput> condition) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setWorkFlowComponent(workFlowComponent);
        workFlowNode.setWorkflowOrthogonalComponents(workFlowComponent.getWorkflowOrthogonalComponents());
        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setCondition(condition);
        edge.setOut(workFlowNode);
        this.getOut().add(edge);
        edge.setIn(workFlowNode);

//        // branchedAt.add(this.getCurrentNode());
//        if (workFlowComponent instanceof WorkFlowBranchSelector) {
//            addBranchSelector((WorkFlowBranchSelector) workFlowComponent);
//        } else {
//            addWorkflowStateProcessor((WorkFlowStateProcessor) workFlowComponent);
//        }
        return workFlowNode;
    }

    public WorkFlowNode andReturn(WorkFlowNode workFlowNode) {
        return workFlowNode;
    }

    public WorkFlowNode addEndEvent(WorkflowEndEvent workflowEndEvent) {

        WorkFlowNode workFlowNode = new WorkFlowNode();
        workFlowNode.setWorkFlowComponent(workFlowComponent);
        workFlowNode.setWorkflowOrthogonalComponents(workFlowComponent.getWorkflowOrthogonalComponents());
        WorkFlowEdge edge = new WorkFlowEdge();
        edge.setOut(workFlowNode);
        this.getOut().add(edge);
        edge.setIn(workFlowNode);

//        // branchedAt.add(this.getCurrentNode());
//        if (workFlowComponent instanceof WorkFlowBranchSelector) {
//            addBranchSelector((WorkFlowBranchSelector) workFlowComponent);
//        } else {
//            addWorkflowStateProcessor((WorkFlowStateProcessor) workFlowComponent);
//        }
        return this;

    }

}

package com.jetty.workflow;

import java.util.List;
import java.util.Set;

/**
 * Created by prakashjetty on 1/28/18.
 */
public abstract class WorkFlowComponent {

    protected WorkflowStatus workflowStatus;

    protected Set<WorkflowUser> actors;

    protected List<WorkflowOrthogonalComponent> workflowOrthogonalComponents;

    public abstract void process(WorkFlowInput workFlowInput);

    public WorkflowStatus getWorkflowStatus() {
        return workflowStatus;
    }

    public void setWorkflowStatus(WorkflowStatus workflowStatus) {
        this.workflowStatus = workflowStatus;
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
}

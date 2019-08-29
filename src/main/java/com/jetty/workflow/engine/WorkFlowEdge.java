package com.jetty.workflow.engine;

import com.jetty.workflow.WorkFlowInput;

import java.util.function.Predicate;

/**
 * Created by prakashjetty on 1/30/18.
 */
public class WorkFlowEdge {

    private WorkFlowNode in;

    private WorkFlowNode out;

    private Predicate<WorkFlowInput> condition;

    public WorkFlowNode getIn() {
        return in;
    }

    public void setIn(WorkFlowNode in) {
        this.in = in;
    }

    public WorkFlowNode getOut() {
        return out;
    }

    public void setOut(WorkFlowNode out) {
        this.out = out;
    }

    public Predicate<WorkFlowInput> getCondition() {
        return condition;
    }

    public void setCondition(Predicate<WorkFlowInput> condition) {
        this.condition = condition;
    }
}

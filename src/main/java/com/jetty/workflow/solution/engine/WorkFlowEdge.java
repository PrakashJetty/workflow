package com.jetty.workflow.solution.engine;

import java.io.Serializable;

/**
 * Created by prakashjetty on 1/30/18.
 */
public class WorkFlowEdge implements Serializable {

    private WorkFlowNode in;

    private WorkFlowNode out;

    private PredicateSerializable condition;

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

    public PredicateSerializable getCondition() {
        return condition;
    }

    public void setCondition(PredicateSerializable condition) {
        this.condition = condition;
    }
}

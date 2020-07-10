package com.jetty.workflow.solution.engine;

/**
 * Created by prakashjetty on 1/28/18.
 */
public enum WorkFlowNodeType {
    START_EVENT, STATE_PROCESSOR, GATEWAY_DIVERGE, GATEWAY_CONVERGE, RULE_TASK, SCRIPT_TASK, NOTIFICATION_EVENT, END_EVENT
}

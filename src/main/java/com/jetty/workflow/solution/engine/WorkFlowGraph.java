package com.jetty.workflow.solution.engine;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by prakashjetty on 11/8/18.
 */

public class WorkFlowGraph implements Serializable {

    private WorkFlowNode currentNode;


    private Map<String, WorkFlowNode> startEventMap = new HashMap<>();

    public Map<String, WorkFlowNode> getStartEventMap() {
        return startEventMap;
    }

    public void setStartEventMap(Map<String, WorkFlowNode> startEventMap) {
        this.startEventMap = startEventMap;
    }

    public WorkFlowGraph() {
    }

    public WorkFlowGraph(WorkFlowNode currentNode) {
        this.currentNode = currentNode;
    }

    public WorkFlowNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(WorkFlowNode currentNode) {
        this.currentNode = currentNode;
    }
}

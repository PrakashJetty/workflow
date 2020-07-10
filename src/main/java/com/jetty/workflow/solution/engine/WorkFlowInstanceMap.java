package com.jetty.workflow.solution.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by prakashjetty on 11/9/18.
 */
public class WorkFlowInstanceMap {

    private static Map<UUID, WorkFlowGraph> workFlowNodeMap = new HashMap<>();

    public static Map<UUID, WorkFlowGraph> getWorkFlowNodeMap() {
        return workFlowNodeMap;
    }


}

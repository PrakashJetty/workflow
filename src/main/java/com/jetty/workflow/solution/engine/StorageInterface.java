package com.jetty.workflow.solution.engine;

/**
 * Created by prakashjetty on 5/20/20.
 */
public interface StorageInterface {

    //void store(UUID id, long hashcode);

    void store(WorkflowResource object,  WorkFlowGraph workFlowGraph);

    //long get(UUID id);

    WorkFlowGraph getObjectgraphById(WorkflowResource object);

    void remove(WorkflowResource object);
}

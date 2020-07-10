package com.jetty.workflow.solution;

import java.io.Serializable;

/**
 * Created by prakashjetty on 11/6/18.
 */
public abstract class WorkflowOrthogonalComponent implements Serializable {

    public abstract void process(WorkFlowInput workFlowInput) throws Exception  ;
}

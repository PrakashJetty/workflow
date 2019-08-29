package com.jetty.workflow;

/**
 * Created by prakashjetty on 1/27/18.
 */
public abstract class WorkFlowInput {

    protected boolean isProcessedSuccessfully;
    protected boolean isProcessedPartially;

    public boolean isProcessedSuccessfully() {
        return isProcessedSuccessfully;
    }

    public void setProcessedSuccessfully(boolean processedSuccessfully) {
        isProcessedSuccessfully = processedSuccessfully;
    }

    public boolean isProcessedPartially() {
        return isProcessedPartially;
    }

    public void setProcessedPartially(boolean processedPartially) {
        isProcessedPartially = processedPartially;
    }
}

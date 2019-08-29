package com.jetty.workflow;

/**
 * Created by prakashjetty on 11/6/18.
 */
public class WorkflowStatus {

    private int statusCode;
    private String status;
    private String description;


    public WorkflowStatus(int statusCode, String status, String description) {
        this.statusCode = statusCode;
        this.status = status;
        this.description = description;
    }

    public WorkflowStatus() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

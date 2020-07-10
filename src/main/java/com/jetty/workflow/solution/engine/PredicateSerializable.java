package com.jetty.workflow.solution.engine;

import com.jetty.workflow.solution.WorkFlowInput;

import java.io.Serializable;
import java.util.function.Predicate;

@FunctionalInterface
public interface PredicateSerializable extends Predicate<WorkFlowInput>, Serializable {

}

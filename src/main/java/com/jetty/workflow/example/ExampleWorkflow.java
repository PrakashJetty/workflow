package com.jetty.workflow.example;

import com.jetty.workflow.WorkFlow;
import com.jetty.workflow.WorkFlowInput;
import com.jetty.workflow.WorkflowDivergeGatewayComponent;
import com.jetty.workflow.WorkflowEndEvent;
import com.jetty.workflow.WorkflowOrthogonalComponent;
import com.jetty.workflow.WorkflowRole;
import com.jetty.workflow.WorkflowRuleTaskComponent;
import com.jetty.workflow.WorkflowStatus;
import com.jetty.workflow.WorkflowUser;
import com.jetty.workflow.engine.WorkFlowGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by prakashjetty on 1/28/18.
 */
public class ExampleWorkflow {

    private WorkFlowGraph workFlowGraph;

    public ExampleWorkflow(WorkFlowGraph workFlowGraph) {
        this.workFlowGraph = workFlowGraph;
    }

    public void configureWorkFlow() {
        WorkFlow workFlow = new WorkFlow();
        FreightCustomerRequestEvent freightCustomerRequestEvent = new FreightCustomerRequestEvent();
        FrieghtPartnerRequestStartEvent frieghtPartnerRequestStartEvent = new FrieghtPartnerRequestStartEvent();
        TicketCreationWorkflowComponent ticketCreationWorkflowComponent = new TicketCreationWorkflowComponent();
        WorkflowStatus fierghtInitiatedStatus = new WorkflowStatus(1000, "TICKET_CREATED", "Freight flow ticket created");
        WorkflowRole ticketCreationRole = new WorkflowRole("CSR");
        WorkflowUser ticketCreatedUser = new WorkflowUser();
        ticketCreatedUser.setRole(ticketCreationRole);
        Set<WorkflowUser> ticketCreationActors = new HashSet<>();
        ticketCreationActors.add(ticketCreatedUser);
        ticketCreationWorkflowComponent.setActors(ticketCreationActors);
        ticketCreationWorkflowComponent.setWorkflowStatus(fierghtInitiatedStatus);


        FrieghtFormSaveWorkflowComponent frieghtFormSaveWorkflowComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus fierghtFormReleaseStatus = new WorkflowStatus(1000, "FREIGHT_RELEASED", "Freight form relased to FP");
        WorkflowRole fierghtFormReleaseRole = new WorkflowRole("CSR");
        WorkflowUser fierghtFormReleaseUser = new WorkflowUser();
        fierghtFormReleaseUser.setRole(fierghtFormReleaseRole);
        Set<WorkflowUser> fierghtFormReleaseActors = new HashSet<>();
        fierghtFormReleaseActors.add(fierghtFormReleaseUser);
        frieghtFormSaveWorkflowComponent.setActors(fierghtFormReleaseActors);
        frieghtFormSaveWorkflowComponent.setWorkflowStatus(fierghtFormReleaseStatus);
        NotificationWorkflowOrthoganalComponent notificationWorkflowOrthoganalComponent = new NotificationWorkflowOrthoganalComponent();
        List<WorkflowOrthogonalComponent> freightReleaseStatusOrthoganalComponents = new ArrayList<>();
        freightReleaseStatusOrthoganalComponents.add(notificationWorkflowOrthoganalComponent);
        frieghtFormSaveWorkflowComponent.setWorkflowOrthogonalComponents(freightReleaseStatusOrthoganalComponents);


        FrieghtFormSaveWorkflowComponent frieghtFormFPSaveWorkflowComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus fierghtFormInProcessStatus = new WorkflowStatus(1000, "FREIGHT_IN_PROCESS", "Freight form in process by FP");
        WorkflowRole fierghtFormInProcessRole = new WorkflowRole("FP");
        WorkflowUser fierghtFormInProcessUser = new WorkflowUser();
        fierghtFormReleaseUser.setRole(fierghtFormInProcessRole);
        Set<WorkflowUser> fierghtFormInProcessActors = new HashSet<>();
        fierghtFormInProcessActors.add(fierghtFormInProcessUser);
        frieghtFormFPSaveWorkflowComponent.setActors(fierghtFormInProcessActors);
        frieghtFormFPSaveWorkflowComponent.setWorkflowStatus(fierghtFormInProcessStatus);


        WorkflowDivergeGatewayComponent changesFromCustomerDivergeGatewayComponent = new WorkflowDivergeGatewayComponent();
//        WorkflowStatus fierghtFormReleaseStatus = new WorkflowStatus(1000, "FREIGHT_RELEASED", "Freight form relased to FP");
        WorkflowRole changesFromCustomerDivergeGatewayComponentRole = new WorkflowRole("CSR");
        WorkflowUser changesFromCustomerDivergeGatewayComponentUser = new WorkflowUser();
        fierghtFormReleaseUser.setRole(changesFromCustomerDivergeGatewayComponentRole);
        Set<WorkflowUser> changesFromCustomerDivergeGatewayComponentActors = new HashSet<>();
        changesFromCustomerDivergeGatewayComponentActors.add(changesFromCustomerDivergeGatewayComponentUser);
        changesFromCustomerDivergeGatewayComponent.setActors(changesFromCustomerDivergeGatewayComponentActors);
//        frieghtFormSaveWorkflowComponent.setWorkflowStatus(fierghtFormReleaseStatus);


        WorkflowDivergeGatewayComponent cancelOrRerouteDivergeGatewayComponent = new WorkflowDivergeGatewayComponent();
//        WorkflowStatus fierghtFormReleaseStatus = new WorkflowStatus(1000, "FREIGHT_RELEASED", "Freight form relased to FP");
        WorkflowRole cancelOrRerouteDivergeGatewayComponentRole = new WorkflowRole("CSR");
        WorkflowUser cancelOrRerouteDivergeGatewayComponentUser = new WorkflowUser();
        fierghtFormReleaseUser.setRole(cancelOrRerouteDivergeGatewayComponentRole);
        Set<WorkflowUser> cancelOrRerouteDivergeGatewayComponentActors = new HashSet<>();
        fierghtFormReleaseActors.add(cancelOrRerouteDivergeGatewayComponentUser);
        cancelOrRerouteDivergeGatewayComponent.setActors(cancelOrRerouteDivergeGatewayComponentActors);
//        frieghtFormSaveWorkflowComponent.setWorkflowStatus(fierghtFormReleaseStatus);

        WorkflowRuleTaskComponent reRouteRuleTaskComponent = new WorkflowRuleTaskComponent();
        WorkflowStatus reRouteRuleTaskComponentStatus = new WorkflowStatus(1000, "FREIGHT_REROUTED", "Freight re routed by FP");
        WorkflowRole reRouteRuleTaskComponentRole = new WorkflowRole("CSR");
        WorkflowUser reRouteRuleTaskComponentUser = new WorkflowUser();
        fierghtFormReleaseUser.setRole(reRouteRuleTaskComponentRole);
        Set<WorkflowUser> reRouteRuleTaskComponentActors = new HashSet<>();
        fierghtFormReleaseActors.add(reRouteRuleTaskComponentUser);
        reRouteRuleTaskComponent.setActors(reRouteRuleTaskComponentActors);
        reRouteRuleTaskComponent.setWorkflowStatus(reRouteRuleTaskComponentStatus);
//        NotificationWorkflowOrthoganalComponent notificationWorkflowOrthoganalComponent = new NotificationWorkflowOrthoganalComponent();
//        List<WorkflowOrthogonalComponent> freightReleaseStatusOrthoganalComponents = new ArrayList<>();
//        freightReleaseStatusOrthoganalComponents.add(notificationWorkflowOrthoganalComponent);
//        reRouteRuleTaskComponent.setWorkflowOrthogonalComponents(freightReleaseStatusOrthoganalComponents);


        FrieghtFormSaveWorkflowComponent bookingDoneComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus bookingDoneComponentStatus = new WorkflowStatus(1000, "FREIGHT_IN_TRANSIST", "Freight form in intransist by FP");
        WorkflowRole bookingDoneComponentRole = new WorkflowRole("FP");
        WorkflowUser bookingDoneComponentUser = new WorkflowUser();
        bookingDoneComponentUser.setRole(bookingDoneComponentRole);
        Set<WorkflowUser> bookingDoneComponentActors = new HashSet<>();
        fierghtFormInProcessActors.add(bookingDoneComponentUser);
        bookingDoneComponent.setActors(bookingDoneComponentActors);
        bookingDoneComponent.setWorkflowStatus(bookingDoneComponentStatus);


        WorkflowEndEvent workflowEndEvent = new WorkflowEndEvent();


        FrieghtFormSaveWorkflowComponent destinationCountryReachedComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus destinationCountryReachedComponentStatus = new WorkflowStatus(1000, "FREIGHT_ARRIVED", "Freight arrived by FP");
        WorkflowRole destinationCountryReachedComponentRole = new WorkflowRole("FP");
        WorkflowUser destinationCountryReachedComponentUser = new WorkflowUser();
        bookingDoneComponentUser.setRole(destinationCountryReachedComponentRole);
        Set<WorkflowUser> destinationCountryReachedComponentActors = new HashSet<>();
        fierghtFormInProcessActors.add(destinationCountryReachedComponentUser);
        destinationCountryReachedComponent.setActors(destinationCountryReachedComponentActors);
        destinationCountryReachedComponent.setWorkflowStatus(destinationCountryReachedComponentStatus);


        FrieghtFormSaveWorkflowComponent approvedComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus approvedComponentStatus = new WorkflowStatus(1000, "FREIGHT_ARRIVED", "Freight arrived by FP");
        WorkflowRole approvedComponentRole = new WorkflowRole("FP");
        WorkflowUser approvedComponentUser = new WorkflowUser();
        bookingDoneComponentUser.setRole(approvedComponentRole);
        Set<WorkflowUser> approvedComponentActors = new HashSet<>();
        fierghtFormInProcessActors.add(approvedComponentUser);
        approvedComponent.setActors(approvedComponentActors);
        approvedComponent.setWorkflowStatus(approvedComponentStatus);


        FrieghtFormSaveWorkflowComponent waitingForClearanceComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus waitingForClearanceComponentStatus = new WorkflowStatus(1000, "FREIGHT_HOLD", "Freight hold by FP");
        WorkflowRole waitingForClearanceComponentRole = new WorkflowRole("FP");
        WorkflowUser waitingForClearanceComponentUser = new WorkflowUser();
        bookingDoneComponentUser.setRole(waitingForClearanceComponentRole);
        Set<WorkflowUser> waitingForClearanceComponentActors = new HashSet<>();
        fierghtFormInProcessActors.add(waitingForClearanceComponentUser);
        waitingForClearanceComponent.setActors(waitingForClearanceComponentActors);
        waitingForClearanceComponent.setWorkflowStatus(waitingForClearanceComponentStatus);


        FrieghtFormSaveWorkflowComponent reachedDestinationComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus reachedDestinationComponentStatus = new WorkflowStatus(1000, "FREIGHT_DELIVERED", "Freight delivered by FP");
        WorkflowRole reachedDestinationComponentRole = new WorkflowRole("FP");
        WorkflowUser reachedDestinationComponentUser = new WorkflowUser();
        bookingDoneComponentUser.setRole(reachedDestinationComponentRole);
        Set<WorkflowUser> reachedDestinationComponentActors = new HashSet<>();
        fierghtFormInProcessActors.add(reachedDestinationComponentUser);
        reachedDestinationComponent.setActors(reachedDestinationComponentActors);
        reachedDestinationComponent.setWorkflowStatus(reachedDestinationComponentStatus);


        FrieghtFormSaveWorkflowComponent podUploadComponent = new FrieghtFormSaveWorkflowComponent();
        WorkflowStatus podUploadComponentStatus = new WorkflowStatus(1000, "FREIGHT_DELIVERED", "Freight delivered by FP");
        WorkflowRole podUploadComponentRole = new WorkflowRole("FP");
        WorkflowUser podUploadComponentUser = new WorkflowUser();
        bookingDoneComponentUser.setRole(podUploadComponentRole);
        Set<WorkflowUser> podUploadComponentActors = new HashSet<>();
        fierghtFormInProcessActors.add(podUploadComponentUser);
        podUploadComponent.setActors(podUploadComponentActors);
        podUploadComponent.setWorkflowStatus(podUploadComponentStatus);
        NotificationWorkflowOrthoganalComponent podUploadComponentnotificationWorkflowOrthoganalComponent = new NotificationWorkflowOrthoganalComponent();
        List<WorkflowOrthogonalComponent> podUploadComponentOrthoganalComponents = new ArrayList<>();
        podUploadComponentOrthoganalComponents.add(podUploadComponentnotificationWorkflowOrthoganalComponent);
        podUploadComponent.setWorkflowOrthogonalComponents(podUploadComponentOrthoganalComponents);

//        Set<WorkFlowNode> startEvents = new HashSet<>();
//        startEvents.add(workFlow.addStartEvent(freightCustomerRequestEvent));
//        startEvents.add(workFlow.addStartEvent(frieghtPartnerRequestStartEvent));
//
        workFlow
                .startBranch(ticketCreationWorkflowComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })

                .addBranch(frieghtFormSaveWorkflowComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addBranch(frieghtFormFPSaveWorkflowComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedPartially();
                    }
                })
                .addBranch(changesFromCustomerDivergeGatewayComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedPartially();
                    }
                })
                .startBranch(cancelOrRerouteDivergeGatewayComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addEndEvent(workflowEndEvent)
                .addBranch(reRouteRuleTaskComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addBranch(bookingDoneComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .endBranch()
                .addBranch(bookingDoneComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addBranch(destinationCountryReachedComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addBranch(approvedComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .startBranch(waitingForClearanceComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addBranch(reachedDestinationComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .endBranch()
                .addBranch(reachedDestinationComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addBranch(podUploadComponent, new Predicate<WorkFlowInput>() {
                    @Override
                    public boolean test(WorkFlowInput workFlowInput) {
                        return workFlowInput.isProcessedSuccessfully();
                    }
                })
                .addEndEvent(workflowEndEvent);
//        workFlowGraph.setCurrentNode(workFlow.getCurrentNode());
        workFlowGraph.getStartEventMap().put("CUSTOMER_INITIATED", workFlow.addStartEvent(freightCustomerRequestEvent));
        workFlowGraph.getStartEventMap().put("FP_INITIATED", workFlow.addStartEvent(frieghtPartnerRequestStartEvent));

    }


    public WorkFlowGraph getWorkFlowGraph() {
        return workFlowGraph;
    }

    public void setWorkFlowGraph(WorkFlowGraph workFlowGraph) {
        this.workFlowGraph = workFlowGraph;
    }
}

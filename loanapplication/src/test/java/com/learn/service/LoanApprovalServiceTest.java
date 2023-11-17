package com.learn.service;

/* 
 * Junit5 test for LoanApprovalService class
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.learn.domain.Customer;
import com.learn.domain.LoanApplication;

public class LoanApprovalServiceTest {

    @Test
    public void testApproveLoan() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(1234)
                .loanAmount(200000)
                .tenure(2)
                .creditScore(4.5f)
                .build();

        Customer customer = new Customer.Builder()
                .customerId(123)
                .name("John")
                .age(25)
                .loanApplication(loanApplication)
                .build();

        LoanApprovalService loanApprovalService = LoanApprovalService.getInstance();

        assertEquals(false, loanApprovalService.approveLoan(customer));
    }

    // Test to check singleton instance
    @Test
    public void testSingleton() {
        LoanApprovalService loanApprovalService1 = LoanApprovalService.getInstance();
        LoanApprovalService loanApprovalService2 = LoanApprovalService.getInstance();
        assertEquals(loanApprovalService1, loanApprovalService2);
    }

    // Test to check successful loan approval
    @Test
    public void testApproveLoanSuccess() {
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(1234)
                .loanAmount(200000)
                .tenure(2)
                .creditScore(8.5f)
                .build();

        Customer customer = new Customer.Builder()
                .customerId(123)
                .name("John")
                .age(25)
                .loanApplication(loanApplication)
                .build();

        LoanApprovalService loanApprovalService = LoanApprovalService.getInstance();

        assertEquals(true, loanApprovalService.approveLoan(customer));
    }


  


}

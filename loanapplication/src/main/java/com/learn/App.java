package com.learn;

import com.learn.domain.Customer;
import com.learn.domain.LoanApplication;
import com.learn.service.LoanApprovalService;

public class App 
{
    public static void main( String[] args )
    {
        // LoanApplication object
        LoanApplication loanApplication = new LoanApplication.Builder()
                .applicationId(1234)
                .loanAmount(200000)
                .tenure(2)
                .creditScore(4.5f)
                .build();

        // Customer object
        Customer customer = new Customer.Builder()
                .customerId(123)
                .name("John")
                .age(25)
                .loanApplication(loanApplication)
                .build();

        // LoanApprovalService object
        LoanApprovalService loanApprovalService = LoanApprovalService.getInstance();

        // call approveLoan method
        boolean isLoanApproved = loanApprovalService.approveLoan(customer);

        // print the result
        System.out.println("Is loan approved? " + isLoanApproved);
  
    }
}

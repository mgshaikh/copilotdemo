package com.learn.service;

/* 
 * LoanApprovalService class with method approveLoan(Customer customer)
 * Create class using Singleton design pattern
 * synchronize object creation
 * 
 */
import com.learn.domain.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanApprovalService {

    private static LoanApprovalService loanApprovalService;

    private static final Logger logger = LoggerFactory.getLogger(LoanApprovalService.class);

    private LoanApprovalService() {
    }

    public static LoanApprovalService getInstance() {
        if (loanApprovalService == null) {
            synchronized (LoanApprovalService.class) {
                if (loanApprovalService == null) {
                    loanApprovalService = new LoanApprovalService();
                }
            }
        }
        return loanApprovalService;
    }

    /**
     * This method is used to approve or reject a loan application.
     *
     * @param customer The customer who has applied for the loan. This object contains all the necessary details like age, loan amount, tenure and credit score.
     * @return boolean This returns true if the loan is approved, otherwise it returns false.
     * 
     * The loan approval is based on the following conditions:
     * 1. The customer's age should be more than 18 and less than 60.
     * 2. The customer's credit score should be more than 7.5.
     * 3. The loan amount requested by the customer should be more than 100,000 and less than 500,000.
     * 4. The tenure of the loan should be less than 5 years.
     */
    public boolean approveLoan(Customer customer) {
        logger.info("Approving loan for customer");

        if (customer == null || customer.getLoanApplication() == null) {
            logger.error("Customer or Loan Application cannot be null");
            throw new IllegalArgumentException("Customer or Loan Application cannot be null");
        }
        
        logger.info("Customer and Loan Application are not null");

        if (customer.getAge() > 18 && customer.getAge() < 60 
                && customer.getLoanApplication().getCreditScore() > 7.5
                && customer.getLoanApplication().getLoanAmount() > 100000
                && customer.getLoanApplication().getLoanAmount() < 500000
                && customer.getLoanApplication().getTenure() < 5
                ) {
            logger.info("Loan approved for customer");
            return true;
        }

        logger.info("Loan not approved for customer");
        return false;
    }
}
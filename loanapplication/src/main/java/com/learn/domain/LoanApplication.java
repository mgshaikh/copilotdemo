package com.learn.domain;

/* 
 * LoanApplication class with fields applicationId, loanAmount,tenure and creditScore(float)
 * Create a Builder class for LoanApplication as a static inner class
 * Add Builder as a parameter in the constructor of LoanApplication
 * 
 */
public class LoanApplication {
    
        private int applicationId;
        private double loanAmount;
        private int tenure;
        private float creditScore;
    
        public LoanApplication(Builder builder) {
            this.applicationId = builder.applicationId;
            this.loanAmount = builder.loanAmount;
            this.tenure = builder.tenure;
            this.creditScore = builder.creditScore;
        }
    
        public int getApplicationId() {
            return applicationId;
        }
    
        public double getLoanAmount() {
            return loanAmount;
        }
    
        public int getTenure() {
            return tenure;
        }
    
        public float getCreditScore() {
            return creditScore;
        }
    
        @Override
        public String toString() {
            return "LoanApplication [applicationId=" + applicationId + ", loanAmount=" + loanAmount + ", tenure=" + tenure
                    + ", creditScore=" + creditScore + "]";
        }
    
        public static class Builder {
            private int applicationId;
            private double loanAmount;
            private int tenure;
            private float creditScore;
    
            public Builder applicationId(int applicationId) {
                this.applicationId = applicationId;
                return this;
            }
    
            public Builder loanAmount(double loanAmount) {
                this.loanAmount = loanAmount;
                return this;
            }
    
            public Builder tenure(int tenure) {
                this.tenure = tenure;
                return this;
            }
    
            public Builder creditScore(float creditScore) {
                this.creditScore = creditScore;
                return this;
            }
    
            public LoanApplication build() {
                return new LoanApplication(this);
            }
        }
    }

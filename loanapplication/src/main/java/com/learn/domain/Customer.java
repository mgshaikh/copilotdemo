package com.learn.domain;

/* 
 * Customer class with fields customerId, name, age and LoanApplication *
 * Create a Builder class for Customer as a static inner class
 * Add Builder as a parameter in the constructor of Customer 
 */
public class Customer {
    
        private int customerId;
        private String name;
        private int age;
        private LoanApplication loanApplication;
    
        public Customer(Builder builder) {
            this.customerId = builder.customerId;
            this.name = builder.name;
            this.age = builder.age;
            this.loanApplication = builder.loanApplication;
        }
    
        public int getCustomerId() {
            return customerId;
        }
    
        public String getName() {
            return name;
        }
    
        public int getAge() {
            return age;
        }
    
        public LoanApplication getLoanApplication() {
            return loanApplication;
        }
    
        @Override
        public String toString() {
            return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", loanApplication="
                    + loanApplication + "]";
        }
    
        public static class Builder {
            private int customerId;
            private String name;
            private int age;
            private LoanApplication loanApplication;
    
            public Builder customerId(int customerId) {
                this.customerId = customerId;
                return this;
            }
    
            public Builder name(String name) {
                this.name = name;
                return this;
            }
    
            public Builder age(int age) {
                this.age = age;
                return this;
            }
    
            public Builder loanApplication(LoanApplication loanApplication) {
                this.loanApplication = loanApplication;
                return this;
            }
    
            public Customer build() {
                return new Customer(this);
            }
        }
    }

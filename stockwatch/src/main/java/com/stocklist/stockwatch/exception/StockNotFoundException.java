package com.stocklist.stockwatch.exception;

public class StockNotFoundException extends RuntimeException {
    
        public StockNotFoundException(String message) {
            super(message);
        }
    
}

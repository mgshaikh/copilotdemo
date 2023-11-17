package com.stocklist.stockwatch.service;

/* Interface with CRUD operations using StockListingRepository
 * Method to get stocks by country from third party api
 */

import java.util.List;

import com.stocklist.stockwatch.model.Stock;
import com.stocklist.stockwatch.model.StockList;

public interface StockListingService {

    // Method to get stocks by country from third party api
    StockList getStocksByCountry(String country);

    // Method to get stocks by exchange 
    List<Stock> getStocksByExchange(String exchange);

    // Method to get stocks by country and exchange 
    List<Stock> getStocksByCountryAndExchange(String country, String exchange);

    // Method to get all stocks from database
    List<Stock> getAllStocks();

    // Method to get stock by symbol from database
    Stock getStockBySymbol(String symbol);

    // Method to add stock to database
    Stock addStock(Stock stock);

    // Method to update stock to database
    Stock updateStock(Stock stock);

    // Method to delete stock from database
    void deleteStock(String symbol);

}
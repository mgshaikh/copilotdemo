package com.stocklist.stockwatch.service;

/* 
 * Implement all methods from StockListingService
 * Use StockListingRepository to perform CRUD operations
 * Use RestTemplate to get stocks by country from third party api
 * base url for api is https://api.twelvedata.com/stocks
 * Add a constant for the baseurl
 * throw custom exception StockNotFoundException if stock is not found 
 * throw custom exception StockAlreadyExistsException if stock is already exists
 */

import java.util.List;
import java.util.Optional;

import com.stocklist.stockwatch.exception.StockAlreadyExistsException;
import com.stocklist.stockwatch.exception.StockNotFoundException;
import com.stocklist.stockwatch.model.Stock;
import com.stocklist.stockwatch.model.StockList;
import com.stocklist.stockwatch.repository.StockListingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockListingServiceImpl implements StockListingService {

    // Autowire StockListingRepository
    @Autowired
    private StockListingRepository stockListingRepository;

    // Autowire RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    // Add a constant for the baseurl
    private static final String BASE_URL = "https://api.twelvedata.com/stocks";

    // Use RestTemplate to get StockList from third party api
    @Override
    public StockList getStocksByCountry(String country) {
        // Use RestTemplate to get StockList from third party api
        StockList stockList = restTemplate.getForObject(BASE_URL + "?country=" + country, StockList.class);
        return stockList;
    }

    // Method to get stocks by exchange
    @Override
    public List<Stock> getStocksByExchange(String exchange) {
        // Use StockListingRepository to get stocks by exchange
        List<Stock> stocks = stockListingRepository.findByExchange(exchange);
        return stocks;
    }

    // Method to get stocks by country and exchange
    @Override
    public List<Stock> getStocksByCountryAndExchange(String country, String exchange) {
        // Use StockListingRepository to get stocks by country and exchange
        List<Stock> stocks = stockListingRepository.findByCountryAndExchange(country, exchange);
        return stocks;
    }

    // Method to get all stocks from database
    @Override
    public List<Stock> getAllStocks() {
        // Use StockListingRepository to get all stocks from database
        List<Stock> stocks = stockListingRepository.findAll();
        return stocks;
    }

    // Method to get stock by symbol from database
    @Override
    public Stock getStockBySymbol(String symbol) {
        // Use StockListingRepository to get stock by symbol from database
        Optional<Stock> stock = stockListingRepository.findById(symbol);
        if (stock.isPresent()) {
            return stock.get();
        } else {
            throw new StockNotFoundException("Stock with symbol " + symbol + " not found");
        }
    }

    // Method to add stock to database
    @Override
    public Stock addStock(Stock stock) {
        // Use StockListingRepository to add stock to database
        Optional<Stock> stock1 = stockListingRepository.findById(stock.getSymbol());
        if (stock1.isPresent()) {
            throw new StockAlreadyExistsException("Stock with symbol " + stock.getSymbol() + " already exists");
        } else {
            return stockListingRepository.save(stock);
        }
    }

    // Method to update stock to database
    @Override
    public Stock updateStock(Stock stock) {
        // Use StockListingRepository to update stock to database
        Optional<Stock> stock1 = stockListingRepository.findById(stock.getSymbol());
        if (stock1.isPresent()) {
            return stockListingRepository.save(stock);
        } else {
            throw new StockNotFoundException("Stock with symbol " + stock.getSymbol() + " not found");
        }
    }

    // Method to delete stock from database
    @Override
    public void deleteStock(String symbol) {
        // Use StockListingRepository to delete stock from database
        Optional<Stock> stock = stockListingRepository.findById(symbol);
        if (stock.isPresent()) {
            stockListingRepository.deleteById(symbol);
        } else {
            throw new StockNotFoundException("Stock with symbol " + symbol + " not found");
        }
    }

}
package com.stocklist.stockwatch.controller;

/* 
 * Controller bean using StockListingService
 * 
 * api endpoint: /api/stocks
 * thirdparty api endpoint: /api/stocks/{country}
 * 
 */

import java.util.List;

import com.stocklist.stockwatch.model.Stock;
import com.stocklist.stockwatch.model.StockList;
import com.stocklist.stockwatch.service.StockListingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stocks")
public class StockListingController {

    // Autowire StockListingService
    @Autowired
    private StockListingService stockListingService;

    // Get stocks by country from third party api
    @GetMapping("/country/{country}")
    public StockList getStocksByCountry(@PathVariable String country) {
        return stockListingService.getStocksByCountry(country);
    }

    // Get stocks by exchange
    @GetMapping("/exchange/{exchange}")
    public List<Stock> getStocksByExchange(@PathVariable String exchange) {
        return stockListingService.getStocksByExchange(exchange);
    }

    // Get stocks by country and exchange
    @GetMapping("/{country}/{exchange}")
    public List<Stock> getStocksByCountryAndExchange(@PathVariable String country, @PathVariable String exchange) {
        return stockListingService.getStocksByCountryAndExchange(country, exchange);
    }

    // Get all stocks from database
    @GetMapping
    public List<Stock> getAllStocks() {
        return stockListingService.getAllStocks();
    }

    // Get stock by symbol from database
    @GetMapping("/{symbol}")
    public Stock getStockBySymbol(@PathVariable String symbol) {
        return stockListingService.getStockBySymbol(symbol);
    }

    // Add stock to database
    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockListingService.addStock(stock);
    }

    // Update stock to database
    @PutMapping
    public Stock updateStock(@RequestBody Stock stock) {
        return stockListingService.updateStock(stock);
    }

    // Delete stock from database
    @DeleteMapping("/{symbol}")
    public void deleteStock(@PathVariable String symbol) {
        stockListingService.deleteStock(symbol);
    }

}
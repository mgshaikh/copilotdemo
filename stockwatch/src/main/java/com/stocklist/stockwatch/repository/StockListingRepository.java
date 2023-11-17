package com.stocklist.stockwatch.repository;

/* 
 * Interface of type JPARepository with Stock as type and String as primary key
 */
import com.stocklist.stockwatch.model.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface StockListingRepository extends JpaRepository<Stock, String> {

    // List of Stocks by exchange
    List<Stock> findByExchange(String exchange);

    // List of stocks by country and exchange using JPQL query annotation
    @Query("SELECT s FROM Stock s WHERE country = ?1 AND exchange = ?2")
    List<Stock> findByCountryAndExchange(String country, String exchange);

}
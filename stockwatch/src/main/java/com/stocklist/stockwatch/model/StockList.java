package com.stocklist.stockwatch.model;

// property data as a list of Stock
// Use Lombok Annotations
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockList {
    private List<Stock> data;
}

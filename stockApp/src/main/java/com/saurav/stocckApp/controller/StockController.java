package com.saurav.stocckApp.controller;

import com.saurav.stocckApp.model.Stock;
import com.saurav.stocckApp.model.StockType;
import com.saurav.stocckApp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    StockService stockService;
    @GetMapping("stocks")
    public List<Stock>getAllStock(){
        return stockService.getAllStock();
    }
    @PostMapping("stocks")
    public String addStocks(@RequestBody List<Stock>stocks){
        return stockService.addStocks(stocks);
    }
    @DeleteMapping("stock/{id}")
    public String deleteStockById(@PathVariable Integer id){
        return stockService.deleteStockById(id);
    }
    @GetMapping("stock/{type}")
    public List<Stock>getStockByTypePriceDesc(@PathVariable StockType type){
        return stockService.getStockByTypePriceDesc(type);
    }
    @GetMapping("stock/timestamp")
    public List<Stock>getStockBirthTimeDesc(){
        return stockService.getStockBirthTimeDesc();
    }
    @PutMapping("stock/type/{type}/increment/{hike}")
    public void updateStockByType(@PathVariable StockType type,@PathVariable Float hike){
         stockService.updateStockByType(type,hike);
    }

}

package com.saurav.stocckApp.service;

import com.saurav.stocckApp.model.Stock;
import com.saurav.stocckApp.model.StockType;
import com.saurav.stocckApp.repository.IStockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    IStockRepo stockRepo;
    public List<Stock> getAllStock() {
        return (List<Stock>) stockRepo.findAll();
    }

    public String addStocks(List<Stock> stocks) {
        if(stocks != null) {
            stockRepo.saveAll(stocks);
            return "Stock list Saved";
        }
        return "Stock not saved !!!";
    }

    public String deleteStockById(Integer id) {
        if(id != null) {
            stockRepo.deleteById(id);
            return "Stock is deleted from our database";
        }
        return "This id "+id +" is not exist in our database";
    }

    public List<Stock> getStockByTypePriceDesc(StockType type) {
        return stockRepo.findByStockTypeOrderByStockPriceDesc(type);
    }

    public List<Stock> getStockBirthTimeDesc() {
        return stockRepo.findByOrderByStockBirthTimeStamp();
    }
    @Transactional
    public void updateStockByType(StockType type, Float hike) {
        stockRepo.updateStockByType(type.name(),hike);
    }
}

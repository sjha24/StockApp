package com.saurav.stocckApp.repository;
import com.saurav.stocckApp.model.Stock;
import com.saurav.stocckApp.model.StockType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStockRepo extends CrudRepository<Stock,Integer> {
    List<Stock> findByStockTypeOrderByStockPriceDesc(StockType type);

    List<Stock> findByOrderByStockBirthTimeStamp();
    @Modifying
    @Query(value = ("UPDATE STOCK SET STOCK_PRICE = (STOCK_PRICE + STOCK_PRICE * (:hike)) WHERE STOCK_TYPE = :type"), nativeQuery = true)
    void updateStockByType(String type, Float hike);
}

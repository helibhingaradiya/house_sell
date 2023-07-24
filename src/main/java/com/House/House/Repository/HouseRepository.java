package com.House.House.Repository;

import com.House.House.Model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {



    @Query(value = "SELECT AVG(h.sale_price) FROM house.house_sells h",nativeQuery = true)
    double getAverageSalePriceOverall();



    @Query(value = "SELECT MAX(h.sale_price) FROM house.house_sells h",nativeQuery = true)
    double getMaxSalePrice();

    @Query(value = "SELECT MIN(h.sale_price) FROM house.house_sells h",nativeQuery = true)
    double getMinSalePrice();

    @Query(value = "SELECT h.location AS location, AVG(h.sale_price) AS average FROM house.house_sells h GROUP BY h.location;",nativeQuery = true)
    List<Object[]> getAverageSalePerLocation();
}

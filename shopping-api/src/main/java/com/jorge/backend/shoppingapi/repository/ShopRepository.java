package com.jorge.backend.shoppingapi.repository;

import com.jorge.backend.shoppingapi.model.Shop;
import model.shopping.dto.ShopReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findAllByUserId(String userId);

    List<Shop> findAllByTotalGreaterThan(BigDecimal value);

    List<Shop> findAllByDateGreaterThan(LocalDate date);

    @Query("SELECT s FROM shop s " +
            "WHERE s.date >= :startDate " +
            "AND (:endDate is null or s.date <= :endDate) " +
            "AND (:minValue is null or s.total >= :minValue)")
    List<Shop> getShopByFilters(LocalDate startDate, LocalDate endDate, BigDecimal minValue);

    @Query("SELECT new model.shopping.dto.ShopReportDTO(COUNT(s.id), SUM(s.total), AVG(s.total)) FROM shop s")
    ShopReportDTO getReportByDate(LocalDate startDate, LocalDate endDate);
}

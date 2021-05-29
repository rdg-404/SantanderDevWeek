package com.project.bootcamp.repository;

import com.project.bootcamp.model.dto.stockDTO;
import com.project.bootcamp.model.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface stockRepository extends JpaRepository<stock, Long> {
    Optional<stock> findByNameAndDate(String name, LocalDate date);

    @Query("SELECT stock " +
            "FROM stock stock " +
            "WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id ")
    Optional<stock> findByStockUpdate(String name, LocalDate date, Long id);

    @Query("SELECT stock " +
            "FROM stock stock " +
            "WHERE stock.date = :date ")
    Optional<List<stock>> findByToday(LocalDate date);
}

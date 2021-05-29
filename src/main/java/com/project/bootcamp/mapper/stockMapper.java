package com.project.bootcamp.mapper;


import com.project.bootcamp.model.dto.stockDTO;
import com.project.bootcamp.model.stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class stockMapper {

    public stock toEntity(stockDTO dto) {
        stock stock = new stock();
        stock.setId(dto.getId());
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        stock.setDate(dto.getDate());
        return stock;
    }

    public stockDTO toDto(stock stock) {
        stockDTO dto = new stockDTO();
        dto.setId(stock.getId());
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        dto.setDate(stock.getDate());
        return dto;
    }

    public List<stockDTO> toDto(List<stock> listStock){
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }
}

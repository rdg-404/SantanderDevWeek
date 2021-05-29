package com.project.bootcamp.service;

import com.project.bootcamp.exceptions.businessException;
import com.project.bootcamp.exceptions.notFoundException;
import com.project.bootcamp.mapper.stockMapper;
import com.project.bootcamp.model.dto.stockDTO;
import com.project.bootcamp.model.stock;
import com.project.bootcamp.repository.stockRepository;
import com.project.bootcamp.util.messageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class stockService {

    @Autowired
    private stockRepository repository;

    @Autowired
    private stockMapper mapper;

    @Transactional
    public stockDTO save(stockDTO dto) {
        Optional<stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optionalStock.isPresent()){
            throw new businessException(messageUtils.STOCK_ALREADY_EXISTS);
        }
        stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional
    public stockDTO update(stockDTO dto) {
        Optional<stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if(optionalStock.isPresent()){
            throw new businessException(messageUtils.STOCK_ALREADY_EXISTS);
        }
        stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional
    public stockDTO delete(Long id) {
        stockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<stockDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public stockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(notFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<stockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(notFoundException::new);
    }
}

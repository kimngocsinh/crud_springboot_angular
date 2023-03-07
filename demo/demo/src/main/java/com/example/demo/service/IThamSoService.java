package com.example.demo.service;

import com.example.demo.entity.ThamSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IThamSoService {
	List<ThamSo> getAllThamSo();
    Page<ThamSo> getAllThamSo(ThamSo thamSo, Date startDate, Date endDate, Pageable pageable);
    ThamSo addThamSo(ThamSo thamSo);
    ThamSo updateThamSo(ThamSo thamSo, Long id);
    void delThamSo(Long id);
    Page<ThamSo> getProcedure(String p_search_value, Integer p_page, Integer p_limit);

}

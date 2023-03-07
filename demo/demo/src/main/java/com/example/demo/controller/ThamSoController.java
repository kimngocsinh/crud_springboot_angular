package com.example.demo.controller;

import com.example.demo.entity.ThamSo;
import com.example.demo.service.IThamSoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/thamso")
@CrossOrigin(origins = "http://localhost:4200")
public class ThamSoController {


    @Autowired
    private IThamSoService thamSoService;
    
//    @GetMapping("")
//    public ResponseEntity<List<ThamSo>> getAllThamSo(){
//    	List<ThamSo> thamSoList = this.thamSoService.getAllThamSo();
//    	return new ResponseEntity<>(thamSoList, HttpStatus.OK);
//    }

    @PostMapping("/list")
    public ResponseEntity<Page<ThamSo>> getAllThamSo(@RequestBody ThamSo thamSo){   	
    	Pageable pageable = PageRequest.of(thamSo.getPage(), thamSo.getSize());    	
        Page<ThamSo> thamSoPages = thamSoService.getAllThamSo(thamSo, thamSo.getStartDate(), thamSo.getEndDate(), pageable);
        return new ResponseEntity<>(thamSoPages, HttpStatus.OK);
    }

    //Dùng JDBC để call procedure
    @PostMapping("/procedure")
    public ResponseEntity<Page<ThamSo>> getThamSoList(@RequestBody ThamSo thamSo) { 	
    	Page<ThamSo> list = thamSoService.getProcedure(thamSo.getTenThamSo(), thamSo.getPage(), thamSo.getSize());
    	return new ResponseEntity<>(list, HttpStatus.OK);
    }



    @PostMapping("/add")
    ResponseEntity<ThamSo> addThamSo(@RequestBody ThamSo thamSo){
        ThamSo newThamSo = this.thamSoService.addThamSo(thamSo);
        return new ResponseEntity<>(newThamSo, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ThamSo> updateThamSo(@RequestBody ThamSo thamSo, @PathVariable("id") Long id){
        ThamSo update = this.thamSoService.updateThamSo(thamSo, id);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ThamSo> delThamSo(@PathVariable("id") Long id){
        thamSoService.delThamSo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

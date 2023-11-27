package com.example.exam.controller;

import com.example.exam.entities.Tran;
import com.example.exam.entities.User;
import com.example.exam.service.TranService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/trans")
public class TranController {
    private final TranService tranService;

    public TranController(TranService tranService) {
        this.tranService = tranService;
    }


    @GetMapping("/getAll")
    public List<Tran> getAll() {
        return tranService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Tran req){
        tranService.save(req);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

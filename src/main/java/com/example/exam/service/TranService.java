package com.example.exam.service;

import com.example.exam.entities.Tran;
import com.example.exam.repo.TranRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranService {
    private final TranRepository tranRepository;

    public TranService(TranRepository tranRepository) {
        this.tranRepository = tranRepository;
    }


    public List<Tran> getAll() {
        return tranRepository.findAll();
    }

    public void save(Tran req) {
        tranRepository.save(req);
    }
}

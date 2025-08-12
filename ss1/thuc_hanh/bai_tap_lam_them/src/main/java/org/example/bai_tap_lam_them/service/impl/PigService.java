package org.example.bai_tap_lam_them.service.impl;

import org.example.bai_tap_lam_them.entity.Pig;
import org.example.bai_tap_lam_them.repository.IPigRepository;
import org.example.bai_tap_lam_them.service.IPigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PigService implements IPigService {
@Autowired
private IPigRepository pigRepository;
    @Override
    public List<Pig> findAll() {
        return pigRepository.findAll();
    }

    @Override
    public boolean add(Pig pig) {
        if (pig.getId() == null || findById(pig.getId()) == null) {
            pigRepository.save(pig);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        if(findById(id)!=null){
            pigRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Integer id, Pig pig) {
        if(findById(id)!=null){
            pig.setId(id);
            pigRepository.save(pig);
            return true;
        }
        return false;
    }

    @Override
    public Pig findById(Integer id) {
        return pigRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Pig> findByName(String keyword,Pageable pageable) {
        return pigRepository.findAllByCountry(keyword,pageable);
    }
}

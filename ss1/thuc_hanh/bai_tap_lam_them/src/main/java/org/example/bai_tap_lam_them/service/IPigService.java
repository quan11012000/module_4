package org.example.bai_tap_lam_them.service;

import org.example.bai_tap_lam_them.entity.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IPigService {
    List<Pig> findAll();
    boolean add(Pig pig);
    boolean deleteById(Integer id);
    boolean update(Integer id, Pig pig);
    Pig findById(Integer id);
    Page<Pig> findByName(String keyword,Pageable pageable);


}

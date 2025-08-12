package org.example.bai_tap_lam_them.repository;

import org.example.bai_tap_lam_them.entity.Pig;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPigRepository extends JpaRepository<Pig,Integer> {
    @Query("SELECT c FROM Pig c WHERE c.country.name LIKE CONCAT('%', :country, '%')")
    Page<Pig> findAllByCountry(@Param("country") String country,Pageable pageable);
}

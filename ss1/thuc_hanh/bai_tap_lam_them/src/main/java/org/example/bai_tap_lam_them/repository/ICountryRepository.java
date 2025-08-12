package org.example.bai_tap_lam_them.repository;

import org.example.bai_tap_lam_them.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Integer> {
}

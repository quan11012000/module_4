package org.example.bai_tap_lam_them.service.impl;

import org.example.bai_tap_lam_them.entity.Country;
import org.example.bai_tap_lam_them.repository.ICountryRepository;
import org.example.bai_tap_lam_them.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService implements ICountryService {
    @Autowired
    private ICountryRepository countryRepository;
    @Override
    public List<Country> showAllCountry() {
        return countryRepository.findAll();
    }
}

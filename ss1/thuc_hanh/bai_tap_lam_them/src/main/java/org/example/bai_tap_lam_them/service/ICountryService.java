package org.example.bai_tap_lam_them.service;

import org.example.bai_tap_lam_them.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICountryService {
    List<Country> showAllCountry();
}

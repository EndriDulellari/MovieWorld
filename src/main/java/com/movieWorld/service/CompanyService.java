package com.movieWorld.service;

import com.movieWorld.exceptions.RecordNotFoundException;
import com.movieWorld.model.Company;
import com.movieWorld.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    public List<Company> getCompanies() {
        return repository.findAll();
    }

    public Company getCompanyById(String id) {
        return repository.findCompanyById(id).orElseThrow(
                () -> new RecordNotFoundException("Company by Id " + id + " not found!")
        );
    }

    public Company addUpdateCompany(Company company) {
        return repository.save(company);
    }

    public void deleteCompany(String id) {
        repository.deleteById(id);
    }
}

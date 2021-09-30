package com.movieWorld.controller;

import com.movieWorld.model.Company;
import com.movieWorld.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyController {

    private final CompanyService service;

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companies = service.getCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") String id){
        Company company = service.getCompanyById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Company> addProduct(@RequestBody Company newCompany){
        Company company = service.addUpdateCompany(newCompany);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Company> updateProduct(@RequestBody Company newCompany){
        Company company = service.addUpdateCompany(newCompany);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }


    @PutMapping("/delete/{id}")
    public ResponseEntity<Company> deleteProduct(@PathVariable("id") String id){
        service.deleteCompany(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}

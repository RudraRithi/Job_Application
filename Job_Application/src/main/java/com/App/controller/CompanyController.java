package com.App.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.model.Company;
import com.App.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private CompanyService companyService;
	
	
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}


	@GetMapping
	public ResponseEntity<List<Company>> getAllCompany(){
		return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company company , @PathVariable Long id){
		companyService.updateCompany(company, id);
		return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		 companyService.createCompany(company);
		return new ResponseEntity<>("Company Created Succesfully", HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		boolean deleted = companyService.deleteById(id);
		if(deleted)
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		
		return new ResponseEntity<>("ID Not found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
		Company company= companyService.getCompanyById(id);
		if(company != null) {
			return new ResponseEntity<>(company, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
		}
		
	}

}

package com.App.service;

import java.util.List;

import com.App.model.Company;

public interface CompanyService {
	
	List<Company> getAllCompany();
	boolean updateCompany(Company company, Long id);
	void createCompany(Company company);
	boolean deleteById(Long id);
	Company getCompanyById(Long id);
	
}

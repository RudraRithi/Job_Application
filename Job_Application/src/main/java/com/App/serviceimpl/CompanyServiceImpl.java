package com.App.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.App.model.Company;
import com.App.repo.CompanyRepo;
import com.App.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepo companyRepo;
	
	public CompanyServiceImpl(CompanyRepo companyRepo) {
		super();
		this.companyRepo = companyRepo;
	}

	@Override
	public List<Company> getAllCompany() {
		return companyRepo.findAll();
	}

	@Override
	public boolean updateCompany(Company company, Long id) {
		Optional<Company> companyOptional= companyRepo.findById(id);
		if(companyOptional.isPresent()) {
		Company company2= companyOptional.get();
		company2.setName(company.getName());
		company2.setDescription(company.getDescription());
		company2.setJobs(company.getJobs());
		companyRepo.save(company2);
		return true;
		}else {  
		return false;
		}
	}

	@Override
	public void createCompany(Company company) {
		companyRepo.save(company);
		
	}

	@Override
	public boolean deleteById(Long id) {
		try {
			companyRepo.deleteById(id);
			return true;
		}catch (Exception e){
		return false;
		}
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepo.findById(id).orElse(null);
	}

	

}

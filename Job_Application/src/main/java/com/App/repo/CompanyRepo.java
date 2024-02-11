package com.App.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.model.Company;

public interface CompanyRepo extends JpaRepository<Company, Long> {

}

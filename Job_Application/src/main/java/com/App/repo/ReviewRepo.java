package com.App.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {

	List<Review> findByCompanyId(Long companyId);

}

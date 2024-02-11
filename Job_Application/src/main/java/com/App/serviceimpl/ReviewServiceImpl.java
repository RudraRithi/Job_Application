package com.App.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.App.model.Company;
import com.App.model.Review;
import com.App.repo.ReviewRepo;
import com.App.service.CompanyService;
import com.App.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepo reviewRepo;
	private final CompanyService companyService;
	
	public ReviewServiceImpl(ReviewRepo reviewRepo, CompanyService companyService) {
		super();
		this.reviewRepo = reviewRepo;
		this.companyService= companyService;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews= reviewRepo.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company= companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			 reviewRepo.save(review);
			 return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Review getReview(Long companyId, Long reviewId) {
		List<Review> reviews= reviewRepo.findByCompanyId(companyId);
		return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
		
		
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
	
		if(companyService.getCompanyById(companyId)!= null) {
			updatedReview.setCompany(companyService.getCompanyById(companyId));
			updatedReview.setId(reviewId);
			reviewRepo.save(updatedReview);
			return true;
			
		}else {
			return false;
		}
		
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if(companyService.getCompanyById(companyId)!= null
				&& reviewRepo.existsById(reviewId)) {
			
			Review review= reviewRepo.findById(reviewId).orElse(null);
			Company company= review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			companyService.updateCompany(company, companyId);
			reviewRepo.deleteById(reviewId);
			return true;
		}else
		return false;
	}

}

package com.printer.jobs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.printer.jobs.models.PricingDetails;
@Repository
public interface PapercutRepository extends CrudRepository<PricingDetails, Integer> {

	List<PricingDetails> findByColorAndDoubleSidedAndSize(boolean color, boolean doubleSided,String size);
	List<PricingDetails> findByDoubleSidedAndSize(boolean doubleSided,String size);

}

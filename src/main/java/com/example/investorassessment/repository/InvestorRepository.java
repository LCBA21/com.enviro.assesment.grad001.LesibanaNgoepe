package com.example.investorassessment.repository;

import com.example.investorassessment.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor,Long> {
}

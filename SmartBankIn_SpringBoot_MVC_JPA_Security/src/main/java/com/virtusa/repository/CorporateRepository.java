package com.virtusa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.virtusa.model.CorporateModel;

public interface CorporateRepository extends JpaRepository<CorporateModel, Integer> {

}

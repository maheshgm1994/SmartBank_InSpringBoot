package com.virtusa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.model.AccountModel;

//@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

	@Query(value = "SELECT ad.account_num FROM account_model ad ORDER BY ad.account_id DESC LIMIT 1", nativeQuery = true)
	Optional<String> getAccNum();

}

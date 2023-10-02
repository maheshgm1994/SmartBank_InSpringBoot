package com.virtusa.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.virtusa.exception.IDNotFoundException;
import com.virtusa.model.AccountModel;
import com.virtusa.model.CustomerModel;
import com.virtusa.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void saveAccount(AccountModel account) {
		System.out.println("saveCustomer");
		accountRepository.save(account);

	}

	public List<AccountModel> listAll() {
		System.out.println("listAll");
		return accountRepository.findAll();

	}

	public Optional<AccountModel> getCustomerById(int id) {

		System.out.println("getCustomerById");
		return accountRepository.findById(id);

	}

	public void deleteCustomer(AccountModel account)

	{
		System.out.println("deleteCustomer");
		accountRepository.delete(account);

	}

	public String generateAccNum(AccountModel account) {
		String accNum = "";
		System.out.println("generateAccNum  for : " + account.getCustomer());

		if (accountRepository.getAccNum().isPresent()) {
			accNum = accountRepository.getAccNum().get();
			System.out.println("last user Account num is : " + accNum);

			try {
				String old_string = accNum.substring(8, accNum.length());
				int i = 1 + Integer.parseInt(accNum.substring(8, accNum.length()));
				String new_string = Integer.toString(i);
				accNum = accNum.replace(old_string, new_string);
				System.out.println(accNum + " replace Printing accNum");
				account.setAccount_num(accNum);
			} catch (Exception e) {
				System.out.println("may be account num issue");
				e.printStackTrace();
			}
		} else if (accountRepository.getAccNum().empty() != null) {
			accNum = "2021VRTS111";
			System.out.println("Static Account Num" + accNum);
		}
		return accNum;

	}

	public int AddMoney(AccountModel accountModel, HttpSession session) {
		int status = 0;

		try {

			int i = (int) session.getAttribute("cid");
			String sql = "SELECT account_Balance FROM account_model Where account_cust=" + i + "";

			List<AccountModel> account = jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<AccountModel>(AccountModel.class));

			for (AccountModel a : account) {
				double currBalance = accountModel.getAccount_Balance();
				System.out.println("currBalance " + currBalance);
				double newBalance = a.getAccount_Balance();
				double totalBalance = currBalance + newBalance;
				System.out.println("totalBal : " + totalBalance);

				String query = "UPDATE account_model SET `account_Balance`=" + totalBalance + " WHERE `account_cust`=" + i
						+ "";
				status = jdbcTemplate.update(query);

			}

			System.out.println("After AddMone");
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public int withdrawMoney(AccountModel accountModel, HttpSession session) {
		int status = 0;

		try {

			int i = (int) session.getAttribute("cid");
			String sql = "SELECT account_Balance FROM account_model Where account_cust=" + i + "";

			List<AccountModel> account = jdbcTemplate.query(sql,
					new BeanPropertyRowMapper<AccountModel>(AccountModel.class));

			for (AccountModel a : account) {
				double newBalance = accountModel.getAccount_Balance();
				System.out.println("newBalance " + newBalance);
				double currBalance = a.getAccount_Balance();
				double totalBalance = currBalance - newBalance;
				System.out.println("totalBal : " + totalBalance);

				String query = "UPDATE account_model SET `account_Balance`=" + totalBalance + " WHERE `account_cust`=" + i
						+ "";
				status = jdbcTemplate.update(query);

			}

			System.out.println("After AddMone");
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}

package com.gs.studentservice.repo;

import com.gs.studentservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepo extends JpaRepository<Account, Long> {

}

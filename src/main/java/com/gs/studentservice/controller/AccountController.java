package com.gs.studentservice.controller;

import com.gs.studentservice.model.Account;
import com.gs.studentservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccountController {

    //// CRUD Operation
    // GEt--> READ -- @GetMapping
    // Post ---> Create -- @PostMapping
    // Put --> update --- @PutMapping

    //Delete-> Delete-->@DeleteMapping

    @Autowired
    private AccountService accountService;


//    @GetMapping("/hello")
//    public String getString(){
//        return "hello world";
//    }

@GetMapping("/account")
public ResponseEntity<?> getAllAccountDetails(){
        List<Account> account = accountService.getAllAccount();
    return new ResponseEntity<>(account, HttpStatus.OK);

}

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount (@RequestBody Account account)
    {
        Account account1 = accountService.createAccount(account);
        return new ResponseEntity<Account>(account1, HttpStatus.OK);
    }

    @DeleteMapping("/account/{id}")
    public Object deleteAccount(@PathVariable Long id){
        if(accountService.getUserById(id).isEmpty()){
          return "NO available data with the id : " + id;
        }
         accountService.deleteAccount(id);
        return "Successfully deleted " + id;
    }

    @PutMapping("/account/{id}")
    public Account updateAccount(
            @RequestBody Account account,
            @PathVariable Long id ){
        if(accountService.getUserById(id).isEmpty()){
            return null;
        }
        Optional<Account> accountById = accountService.getUserById(id);
        return accountService.updateAccount(accountById, account);
    }

}

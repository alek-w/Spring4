package net.thumbtack.be.service;

import net.thumbtack.be.persistence.entity.Account;

import java.util.List;


public interface AccountService {

    Account create(Account account);

    Account get(Long id);

    Account update(Account account);

    void delete(Long id);

    Account findById(Long id);

    List<Account> getAll();
}

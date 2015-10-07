package net.thumbtack.be.service.impl;

import net.thumbtack.be.persistence.dao.AccountDao;
import net.thumbtack.be.persistence.entity.Account;
import net.thumbtack.be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service("accountService")
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> getAll() {
        return accountDao.getAll();
    }

    @Override
    public Account update(Account account) {
        return accountDao.update(account);
    }

    @Override
    public void delete(Long id) {
        accountDao.delete(id);
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public Account create(Account account) {
        return accountDao.create(account);
    }

    @Override
    public Account get(Long id) {
        return accountDao.get(id);
    }
}

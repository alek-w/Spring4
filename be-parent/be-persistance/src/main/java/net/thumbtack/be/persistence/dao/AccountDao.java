package net.thumbtack.be.persistence.dao;

import net.thumbtack.be.persistence.entity.Account;


public interface AccountDao extends GenericDao<Account, Long> {
    Account findById(Long id);
}

package net.thumbtack.be.persistence.dao.impl;

import net.thumbtack.be.persistence.dao.AccountDao;
import net.thumbtack.be.persistence.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Repository("accountDao")
public class AccountDaoImpl extends GenericDaoImpl<Account, Long> implements AccountDao {
    @Override
    public Account findById(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Account> query = builder.createQuery(Account.class);
        Root<Account> root = query.from(Account.class);
        query.select(root);

        Path<String> path = root.get("id");
        Predicate predicate = builder.equal(path, id);
        query.where(predicate);

        TypedQuery<Account> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }
}

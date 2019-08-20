package com.gxa.eloan.common.service.impl;

import com.gxa.eloan.common.domain.Account;
import com.gxa.eloan.common.mapper.AccountMapper;
import com.gxa.eloan.common.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    public void add(Account account) {
        accountMapper.insert(account);
    }

    @Override
    public void update(Account account) {
        int res = accountMapper.updateByPrimaryKey(account);
        if (0 == res) {
            throw new RuntimeException("更新失败，乐观锁版本失效，Account：" + account.getId());
        }
    }

    @Override
    public Account getCurrentAccount(Long id) {
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }

}


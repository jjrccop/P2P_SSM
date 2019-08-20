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
}


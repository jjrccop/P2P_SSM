package com.gxa.eloan.common.util.Init;

import com.gxa.eloan.common.domain.Account;

import java.math.BigDecimal;

public class AccountInit {
    public Account getInitAccount(){
        Account account=new Account();
        account.setBorrowlimit(BigDecimal.ZERO);
        account.setFreezedamount(BigDecimal.ZERO);
        account.setRemainborrowlimit(BigDecimal.ZERO);
        account.setUnreceiveinterest(BigDecimal.ZERO);
        account.setUnreceiveprincipal(BigDecimal.ZERO);
        account.setUnreturnamount(BigDecimal.ZERO);
        account.setUsableamount(BigDecimal.ZERO);
        account.setVersion(0);
        return account;
    }
}

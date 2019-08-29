package com.gxa.eloan.common.service;

public interface IVerifyCodeService {

    void sendVerifyCode(String phoneNumber);

    boolean validate(String phoneNumber, String verifyCode);

}


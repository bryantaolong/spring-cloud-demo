package com.bryan.account.service.impl;

import com.bryan.account.mapper.AccountTblMapper;
import com.bryan.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountTblMapper accountTblMapper;

    @Override
    public void debit(String userId, int money) {
        // 扣减账户余额
        accountTblMapper.debit(userId, money);
    }
}

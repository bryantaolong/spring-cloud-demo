package com.bryan.account.controller;

import com.bryan.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    /**
     * 扣减账户余额
     *
     * @return
     */
    @GetMapping("/debit")
    public String debit(@RequestParam("userId") String userId,
                        @RequestParam("money") int money) {
        accountService.debit(userId, money);
        return "account debit success";
    }

}

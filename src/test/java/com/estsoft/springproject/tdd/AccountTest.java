package com.estsoft.springproject.tdd;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(10_000);
    }

    @Test
    public void test() {
        // JUnit, AssertJ, hamcrest 사용 (이전의 if 문을 대신해서 할 수 있음)
        assertThat(account.getBalance(), is(10000));    // hamcrest로 검증

        account = new Account(20000);
        assertThat(account.getBalance(), is(20000));
    }

    @Test
    public void testDeposit() {
        account = new Account(10000);
        account.deposit(100_000);
        assertThat(account.getBalance(), is(110_000));
    }

    @Test
    public void testWithdraw() {
        account = new Account(10000);
        account.withDraw(5000);
        assertThat(account.getBalance(), is(15_000));

        account.withDraw(16_000);
        assertThat(account.getBalance(), is(15_000));
    }
}

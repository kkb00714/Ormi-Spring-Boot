package com.estsoft.springproject.tdd;

public class Account {
    private int balance;

    public Account(int i) {
        this.balance = i;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withDraw(int money) {
        if (this.balance < money) {
            System.out.println("출금 실패");
        } else {
            this.balance -= money;
        }
    }
}

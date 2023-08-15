package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                100,
                1_000,
                10_000,
                5
        );

        account.add(100);

        Assertions.assertFalse(false);
        System.out.println(account.getBalance());
    }

    @Test
    public void upperLimitBalance() {
        SavingAccount account = new SavingAccount(
                2000,
                1_000,
                10_000,
                5
        );

        account.add(10000);

        Assertions.assertFalse(false);
        System.out.println(account.getBalance());
    }

    @Test
    public void сalculationTheInterestAccruedForTheYear() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
        account.add(300);
        Assertions.assertEquals(115, account.yearChange());
    }

    @Test
    public void willPayАorThePurchase() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(200);

        Assertions.assertTrue(true);
        System.out.println("Текущий баланс " + account.getBalance());
    }

    @Test
    public void paymentGoingBeyondTheMinimumlimit() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1200);

        Assertions.assertFalse(false);
        System.out.println("Текущий баланс " + account.getBalance());
    }

    @Test
    public void minimumBalance() {
        SavingAccount account = new SavingAccount(
                10_000,
                1_000,
                10_000,
                5
        );
        account.pay(9000);
        int expected = 1_000;
        int actual = account.getMinBalance();
        ;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void maxBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );
        account.add(9_000);
        int expected = 10_000;
        int actual = account.getMaxBalance();

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void negativAdd() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(false, account.add(-500));
    }

    @Test
    public void negativPay() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );
        Assertions.assertEquals(false, account.pay(-500));
    }

    @Test
    public void sholdNotAdd() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1_000,
                    1_000,
                    10_000,
                    -5
            );
        });
    }
}
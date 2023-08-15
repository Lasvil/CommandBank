package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldNotAdd(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    0,
                    5000,
                    -456
            );
        } );
    }

    @Test
    public void giveMeCreditLimit(){
        CreditAccount account = new CreditAccount(
                0,
                4567,
                400
        );

        Assertions.assertEquals(4567, account.getCreditLimit());
    }

    @Test
    public void changeAndGiveMeRate(){
        CreditAccount account = new CreditAccount(
                54,
                4237,
                257
        );

        account.setRate(654);

        Assertions.assertEquals(654, account.getRate());
    }

    @Test
    public void shouldPayWithoutCredit(){
        CreditAccount account = new CreditAccount(
                500,
                500,
                15
        );

        account.pay(100);

        Assertions.assertEquals(400, account.getBalance());
    }

    @Test
    public void shouldPayWithCredit(){
        CreditAccount account = new CreditAccount(
                500,
                500,
                15
        );

        account.pay(900);

        Assertions.assertEquals(-400, account.getBalance());
    }

    @Test
    public void shouldNotPay(){
        CreditAccount account = new CreditAccount(
                500,
                500,
                15
        );

        Assertions.assertEquals(false, account.pay(1200));
    }

    @Test
    public void shouldAddBalance(){
            CreditAccount account = new CreditAccount(
                    750,
                    1000,
                    15
            );

            Assertions.assertEquals(true, account.add(1000));
        }

    @Test
    public void shouldNotAddBalance(){
        CreditAccount account = new CreditAccount(
                750,
                1000,
                15
        );

        Assertions.assertEquals(false, account.add(-1000));
    }

    @Test
    public void percentOfNegativeBalance(){
        CreditAccount account = new CreditAccount(
                1000,
                1000,
                15
        );

        account.pay(1400);

        Assertions.assertEquals(60, account.yearChange());
    }

    @Test
    public void percentOfPositiveBalance(){
        CreditAccount account = new CreditAccount(
                1000,
                1000,
                15
        );

        account.pay(400);

        Assertions.assertEquals(0, account.yearChange());
    }
}


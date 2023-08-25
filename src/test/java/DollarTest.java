import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    void testMultiplication() {
        Money five = Money.dollar(5);
        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    void testEquality() {
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.dollar(5))).isFalse();
    }

    @Test
    void testCurrency() {
        assertThat(Money.dollar(1).currency()).isEqualTo("USD");
        assertThat(Money.franc(1).currency()).isEqualTo("CHF");
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertThat(sum.augend).isEqualTo(five);
        assertThat(sum.addend).isEqualTo(five);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertThat(result).isEqualTo(Money.dollar(7));
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    void testIdentifyRate() {
        assertThat(new Bank().rate("USD", "USD")).isEqualTo(1);
    }

    @Test
    void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrances = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrances), "USD");
        assertThat(result).isEqualTo(Money.dollar(10));
    }

    @Test
    void testSumPlusMoney() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrances = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrances).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertThat(result).isEqualTo(Money.dollar(15));
    }

    @Test
    void testSumTimes() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrances = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrances).times(2);
        Money result = bank.reduce(sum, "USD");
        assertThat(result).isEqualTo(Money.dollar(20));
    }

}

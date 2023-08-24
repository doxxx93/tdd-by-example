import org.junit.jupiter.api.Test;

public class DollarTest {

    @Test
    void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(product.amount).isEqualTo(10);
        five.times(3);
        assertThat(product.amount).isEqualTo(15);
    }
}

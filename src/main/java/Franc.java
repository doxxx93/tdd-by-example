public class Franc extends Money {
    private String currency;
    public Franc(int amount) {
        this.amount = amount;
        currency = "CHF";
    }


    public Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    String currency() {
        return currency;
    }
}

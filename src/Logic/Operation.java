package Logic;

public enum Operation {

    ADD("+"), SUBTRACT("-"), MULTIPLY("×"), DIVIDE("÷"), NONE("");

    private final String symbol;
    Operation(String symbol) { this.symbol = symbol; }
    public String getSymbol() { return symbol; }

}
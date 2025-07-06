public class FinancialForecast {
    public static double forecastValue(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;
        return forecastValue(presentValue, rate, years - 1) * (1 + rate);
    }
    public static double forecastValueMemo(double presentValue, double rate, int years, double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];

        memo[years] = forecastValueMemo(presentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }
}

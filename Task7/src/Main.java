public class Main {
    public static void main(String[] args) {
        double presentValue = 10000;
        double rate = 0.10; 
        int years = 5;

        System.out.println(" Recursive Forecast:");
        double result = FinancialForecast.forecastValue(presentValue, rate, years);
        System.out.printf("Future Value after %d years: ₹%.2f\n", years, result);

        System.out.println("\n Optimized Recursive Forecast (Memoization):");
        double[] memo = new double[years + 1];
        double resultMemo = FinancialForecast.forecastValueMemo(presentValue, rate, years, memo);
        System.out.printf("Future Value after %d years: ₹%.2f\n", years, resultMemo);
    }
}

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting
{

    private static Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double currentValue, double growthRate, int periods)
    {
        if (periods == 0)
        {
            return currentValue;
        }
        if (memo.containsKey(periods))
        {
            return memo.get(periods);
        }
        double futureValue = calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args)
    {
        double currentValue = 1000.0;
        double growthRate = 0.05;
        int periods = 10;

        double futureValue = calculateFutureValue(currentValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: Rs." + futureValue);
    }
}

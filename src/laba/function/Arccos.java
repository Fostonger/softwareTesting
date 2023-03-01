package function;

import java.util.stream.LongStream;

public class Arccos {
    public double computeSeries(double x, int n) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            Double apply = apply(x, i);
            sum += apply;
        }
        return Math.PI/2 - sum;
    }

    private Double apply(Double x, Integer n) {
        return (Math.pow(x, 1+2*n) * pochOfHalf(n) / ( factorial((long)n)+2*n*factorial((long)n)));
    }
    private long factorial(Long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (long x, long y) -> x * y);
    }
    private double doubleFactorial(Long n) {
        return n <= 0 ? 1 : factorial(n) / ( Math.pow(2d,(n-1d) / 2d) * factorial((n-1) / 2));
    }
    private Double pochOfHalf(Integer n) {
        return doubleFactorial((long)2*n-1) / Math.pow(2,n);
    }
}

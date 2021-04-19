import java.util.ArrayList;
import java.util.List;

public class PrimzahlRechner extends Thread {
    private int start;
    private int limit;
    private List<Integer> primeNumbers = new ArrayList();

    public PrimzahlRechner(int start, int limit) {
        this.start = start;
        this.limit = limit;
        Runnable calculatePrimes = () -> this.calculatePrimeNumbers();
        var thread = new Thread(calculatePrimes);
        thread.start();
    }

    protected void calculatePrimeNumbers() {
        for (int i=this.start; i < this.limit; i++)
            if (this.isPrime(i))
                this.primeNumbers.add(i);

        System.out.println(this.primeNumbers);
    }

    protected boolean isPrime(int n) {
        // Using 6k+-1 optimization
        if (n <= 3)
            return n > 1;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        int i = 5;
        while (Math.pow(((double) i), 2.00) <= n) {
            if (n % i ==  0 || n % (i+2) == 0)
                return false;
            i += 6;
        }
        return true;
    }
}

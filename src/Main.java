import java.net.CookieHandler;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static List<Integer> fib_memo = new ArrayList<>();

    public static int fib(int n){
        if(n >= fib_memo.size()){
            fib_memo.add(fib(n-1) + fib(n-2));
        }
        return fib_memo.get(n);
    }

    public static void main(String[] args) {
        // Initialize fib_memo
        fib_memo.add(1);
        fib_memo.add(1);

        System.out.println("fib(1101) = " + (fib(1101)));
        System.out.println("Integer max: " + Integer.MAX_VALUE);
    }
}
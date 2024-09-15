import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * create an object
         * create index for so that we know which index to count the Fibonacci numbers again
         */
        Fibonachi fib = new Fibonachi();
        int index;
        /**
         * Request and read our index
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index: ");
        index = sc.nextInt();
        fib.setIndex(index) ;

        /**
         * We create an array of size n and fill it with the value null and we add + 1
         * to get the correct index since the index starts from 0 and not from 1
         */
        Long[] memo = new Long[index + 1];

        /**
         * Counting pure Fibonacci on a specific index
         * that is, if the index is 12, then result = 144
         */
        long result = Fibonachi.fibonachiCalculate(fib.getIndex(), memo);
        System.out.println("Fibonacci number at index " + fib.getIndex() + " is: " + result);

        /**
         * 1.select an array for Fibonacci numbers
         * 2.Fill our array with Fibonacci numbers up to index = n
         */
        long[] fibonacciFulling = new long[index + 1];
        for(int i =0;i<=index;i++){
            fibonacciFulling[i] = Fibonachi.fibonachiCalculate(i, memo);
        }
        /**
         * output all the numbers to our index
         */
        System.out.println("Fibonacci numbers:");
        for (int i = 0; i <= index; i++) {
            System.out.println("F|" + i + "| = " + fibonacciFulling[i]);
        }
        /**
         * we use Fibonacci number checks and calculations for our formula w^3 + 1 to the power of one
         */
        System.out.println("Numbers that can be written as W^3 + 1:");
        for (int i = 0; i <= index; i++) {
            if(Fibonachi.CheckNumber((int)fibonacciFulling[i])){
                long res = (long) Math.cbrt(fibonacciFulling[i] - 1);
                //Skip 0 since 0 does not fit us
                if(res <0){
                    continue;
                }else {

                    System.out.println(res + "^3" + "+ 1" + " == " + fibonacciFulling[i]);
                }
            }

        }


    }
}
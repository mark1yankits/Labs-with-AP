public class Fibonachi {
    /**
     * Field for saving the Fibonacci number index
     */
    private int index;

    /**
     * Constructor that initializes the index to 0
     */
    public Fibonachi() {
        this.index = 0;
    }

    /**
     * Method that takes the index of the Fibonacci number
     * @param index
     * @return the current index value
     */
    public int setIndex(int index) {
        return this.index = index;
    }

    /**
     * A method that returns an index
     *
     * @return - the current index value
     */
    public int getIndex(){
        return index;
    }

    /**
     * A method for calculating the Fibonacci number recursively
     * @param index - fibonacci number index
     * @param memo - an array where we write the already calculated numbers,
     *             this is done in order to prevent re-calculation
     * @return - returns the Fibonacci number by the current index
     */
        public static long fibonachiCalculate(int index,Long[] memo) {
            // F[0] = 0  and F[1] = 1
            if(index == 0 || index == 1){
                memo[index] = (long)index;
                return index;
            }
            //if the result has not yet been calculated according to this index
            if(memo[index] == null){
                // recursively calculate F[n-1] + F[n-2] and save it to the memo array
                long res = fibonachiCalculate(index - 1, memo) + fibonachiCalculate(index - 2, memo);
                memo[index] = res;
            }
            //return result
            return memo[index];
        }

    /**
     * a method to check if a number can be written as w^3 + 1
     * 0^3+1 == 1 - 1
     * @param num - number to be checked
     * @return - true if the number can be represented as W^3 + 1, false otherwise
     */
    public static boolean CheckNumber(int num){

            long w = Math.round(Math.cbrt(num-1));
            //0^3+1 == 1 - 1
            //1^3 + 1 == 2 - 1
            return w * w * w == num -1;
        }
}

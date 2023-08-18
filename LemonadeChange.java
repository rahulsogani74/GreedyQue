public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount < 1) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LemonadeChange solution = new LemonadeChange();
        int[] bills = {5, 5, 5, 10, 20};
        boolean possible = solution.lemonadeChange(bills);
        System.out.println("Is it possible to provide change? " + possible);
    }
}

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int result = -1;
        long currentGuess = -1;
        long minValue = 0;
        long maxValue = n;

        while (result != 0) {
            currentGuess = (minValue + maxValue) / 2;
            result = guess((int) currentGuess);
            if (result == -1) {
                maxValue = currentGuess - 1;
            } else {
                minValue = currentGuess + 1;
            }
        }

        return (int) currentGuess;
    }
}
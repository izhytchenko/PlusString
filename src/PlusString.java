public class PlusString extends TextProgram {
    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number:  ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {
        String result = "";
        String longestStr = n1.length() >= n2.length() ? n1 : n2;
        String shortestStr = n2.length() <= n1.length() ? n2 : n1;

        for (int i = longestStr.length() - shortestStr.length(); i > 0; i--) {
            shortestStr = "0" + shortestStr;
        }
        boolean isChange = false;

        for (int i = shortestStr.length(); i > 0; i--) {
            int num1 = Integer.parseInt(String.valueOf(shortestStr.charAt(i - 1)));
            int num2 = Integer.parseInt(String.valueOf(longestStr.charAt(i - 1)));
            int sum = num1 + num2;

            if (isChange) {
                sum += 1;
            }
            if (sum >= 10) {
                isChange = true;
                sum %= 10;
            } else {
                isChange = false;
            }
            result = sum + result;
        }
        if (isChange) {
            result = "1" + result;
        }
        return result;
    }
}

class Solution {

    public int getSum(int a, int b) {

        while (b != 0) {

            // Carry
            int carry = (a & b) << 1;

            // Sum without carry
            a = a ^ b;

            // New carry
            b = carry;
        }

        return a;
    }
}
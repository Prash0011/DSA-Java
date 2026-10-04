package basicmaths;

class Solution {

    public int reverse(int x) {

        int ans = 0;

        while (x != 0) {

            int rem = x % 10;
            x /= 10;

            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;

            if (ans > max / 10) {
                return 0;
            }

            if (ans == max / 10 && rem > 7) {
                return 0;
            }

            if (ans < min / 10) {
                return 0;
            }

            if (ans == min / 10 && rem < -8) {
                return 0;
            }

            ans = ans * 10 + rem;
        }

        return ans;
    }
}

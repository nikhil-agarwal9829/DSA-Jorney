import java.util.*;

class Solution {

    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void add(int index, int value) {
            index++;

            while (index < bit.length) {
                bit[index] += value;
                index += index & -index;
            }
        }

        int sum(int index) {
            index++;

            int ans = 0;

            while (index > 0) {
                ans += bit[index];
                index -= index & -index;
            }

            return ans;
        }

        int rangeSum(int l, int r) {
            if (l > r)
                return 0;

            return sum(r) - (l == 0 ? 0 : sum(l - 1));
        }
    }

    public int[] resultArray(int[] nums) {

        int n = nums.length;

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<>();

        int id = 0;

        for (int x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, id++);
            }
        }

        Fenwick bit1 = new Fenwick(id);
        Fenwick bit2 = new Fenwick(id);

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // First two elements
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        bit1.add(rank.get(nums[0]), 1);
        bit2.add(rank.get(nums[1]), 1);

        for (int i = 2; i < n; i++) {

            int x = nums[i];
            int r = rank.get(x);

            // Number of elements <= x
            int lessEqual1 = bit1.sum(r);
            int lessEqual2 = bit2.sum(r);

            // Number of elements > x
            int greater1 = arr1.size() - lessEqual1;
            int greater2 = arr2.size() - lessEqual2;

            if (greater1 > greater2) {

                arr1.add(x);
                bit1.add(r, 1);

            } else if (greater2 > greater1) {

                arr2.add(x);
                bit2.add(r, 1);

            } else {

                if (arr1.size() <= arr2.size()) {

                    arr1.add(x);
                    bit1.add(r, 1);

                } else {

                    arr2.add(x);
                    bit2.add(r, 1);
                }
            }
        }

        int[] ans = new int[n];

        int index = 0;

        for (int x : arr1)
            ans[index++] = x;

        for (int x : arr2)
            ans[index++] = x;

        return ans;
    }
}
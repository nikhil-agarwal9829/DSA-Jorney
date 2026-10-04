class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Start with the empty subset
        res.add(new ArrayList<>());

        for (int num : nums) {
            int size = res.size();
            // For every existing subset, create a new one by adding the current number
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(res.get(i));
                newSubset.add(num);
                res.add(newSubset);
            }
        }

        return res;
    }
} 
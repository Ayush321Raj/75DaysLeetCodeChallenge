class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, candidates, target,
                  new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index,
                           int[] candidates,
                           int target,
                           List<Integer> path,
                           List<List<Integer>> result) {

        // Found valid combination
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Invalid cases
        if (target < 0 || index == candidates.length) {
            return;
        }

        // INCLUDE current number
        path.add(candidates[index]);

        backtrack(index,
                  candidates,
                  target - candidates[index],
                  path,
                  result);

        // BACKTRACK
        path.remove(path.size() - 1);

        // EXCLUDE current number
        backtrack(index + 1,
                  candidates,
                  target,
                  path,
                  result);
    }
}
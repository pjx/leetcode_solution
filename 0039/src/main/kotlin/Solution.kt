class Solution {
    var result: MutableList<List<Int>> = ArrayList()

    fun solve(current : MutableList<Int>, currentValue : Int, candidates: List<Int>, candidatePos : Int, target: Int) {
        if (currentValue == target) {
            result.add(current.toIntArray().asList())
            return
        }
        for (i in candidatePos until candidates.size) {
            if (currentValue + candidates[i] <= target) {
                current.add(candidates[i])
                solve(current, currentValue + candidates[i], candidates, i, target)
                current.removeAt(current.size - 1)
            }
        }
    }
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        result.clear()
        var current : MutableList<Int> = ArrayList()
        solve(current, 0, candidates.toMutableList(), 0, target)
        return result
    }
}
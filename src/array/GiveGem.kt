package array

class GiveGem {
    fun giveGem(gem: IntArray, operations: Array<IntArray>): Int {
        for (operation in operations){
            gem[operation[1]] += gem[operation[0]]/2
            gem[operation[0]] -= gem[operation[0]]/2
        }
        return gem.max()!! - gem.min()!!
    }
}
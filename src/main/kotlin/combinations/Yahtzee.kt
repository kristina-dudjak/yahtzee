package combinations

import LockableDie

class Yahtzee : Combination {

    private var score: Int = 0

    override fun checkCombination(dice: List<LockableDie>): Int {
        val first = dice[0].number
        var cnt = 0
        for(die: LockableDie in dice){
            if(die.locked){
                if(die.number == first){
                    cnt++
                }
            }
        }
        if(cnt == 6){
            score = 50
        }
        return score
    }
}
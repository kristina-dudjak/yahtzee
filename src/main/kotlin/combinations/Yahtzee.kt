package combinations

import LockableDie

class Yahtzee : Combination {

    var score: Int = 0

    override fun checkCombination(dice: List<LockableDie>): Int {
        val first = dice[0].number
        for(die: LockableDie in dice){
            if(!die.locked){
                if(die.number == first){
                    score = 50
                }
            }
        }
        return score
    }
}
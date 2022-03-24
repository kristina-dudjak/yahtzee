package combinations

import LockableDie

class Poker : Combination {

    var score: Int = 0

    override fun checkCombination(dice: List<LockableDie>): Int {
        var cnt1 = 0
        var cnt2 = 0
        val first = dice[0].number
        for(die: LockableDie in dice){
            if(!die.locked){
                if(die.number == first){
                    cnt1++
                }
                else{
                    val second = die.number
                    if(die.number == second){
                        cnt2++
                    }
                }
            }
        }
        if((cnt1 == 4 || cnt2 == 4)){
            score = 40
        }
        return score
    }
}
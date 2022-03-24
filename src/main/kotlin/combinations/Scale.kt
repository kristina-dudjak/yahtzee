package combinations

import LockableDie

class Scale : Combination {

    var score: Int = 0

    override fun checkCombination(dice: List<LockableDie>): Int {
        var cnt1 = 0
        var cnt2 = 0
        var cnt3 = 0
        var cnt4 = 0
        var cnt5 = 0
        var cnt6 = 0

        for (die: LockableDie in dice){
            if(!die.locked){
                if(die.number == cnt1){
                    cnt1++
                }
                if(die.number == cnt2){
                    cnt2++
                }
                if(die.number == cnt3){
                    cnt3++
                }
                if(die.number == cnt4){
                    cnt4++
                }
                if(die.number == cnt5){
                    cnt5++
                }
                if(die.number == cnt6){
                    cnt6++
                }
            }
        }
        if(cnt1 == 1 && cnt2 == 1 && cnt3 == 1 && cnt4 == 1 && cnt5 == 1){
            score = 15
        }
        if(cnt6 == 1 && cnt2 == 1 && cnt3 == 1 && cnt4 == 1 && cnt5 == 1){
            score = 20
        }
        return score
    }

}
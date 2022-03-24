package combinations

import LockableDie

interface Combination {

    fun checkCombination(dice: List<LockableDie>): Int
}
import combinations.Category
import kotlin.random.Random

class Player {
    var dice = List(6) { LockableDie()}
    var card = Card()


    fun rollDice(){
        for(die: LockableDie in dice){
            if(!die.locked){
                die.number = Random.nextInt(1, 7)
            }
        }
    }

    fun getLockedDiceNumbers(): String{
        return buildString {
            for(die: LockableDie in dice) {
                if(die.locked) {
                    append(die.number.toString() + " ")
                }
            }
        }
    }

    fun lockDice(indices: List<Int>){
        for(index in indices){
            dice[index].locked = true
        }
    }

    fun unlockDice(indices: List<Int>){
        for(index in indices){
            dice[index].locked = false
        }
    }

    fun writePoints(category: Category): Boolean {
        return if (!card.containsCategory(category)) {
            val score = category.combination.checkCombination(dice)
            card.writeScore(category, score)
            true
        } else false
    }






}
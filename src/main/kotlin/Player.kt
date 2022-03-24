import combinations.Category
import combinations.Poker
import combinations.Scale
import combinations.Yahtzee
import kotlin.random.Random

class Player {
    var dice = List(6) { LockableDie()}
    private lateinit var card : Card


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

    fun chooseCombination(number: Int): Int{
        var score = 0
        when (number) {
            1 -> {
                val poker = Poker()
                score = poker.checkCombination(dice)
                card.writeScore(Category.POKER, score)
            }
            2 -> {
                val scale = Scale()
                score = scale.checkCombination(dice)
                card.writeScore(Category.SCALE, score)
            }
            3 -> {
                val yahtzee = Yahtzee()
                score = yahtzee.checkCombination(dice)
                card.writeScore(Category.YAHTZEE, score)
            }
        }
        return score
    }






}
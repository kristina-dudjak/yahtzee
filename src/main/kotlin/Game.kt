import combinations.Combination
import combinations.Poker
import combinations.Scale
import combinations.Yahtzee

class Game {

    private var players = List(2){Player()}
    private var throwCounter : Int = 0
    private var combinations : List<Combination> = listOf(Poker(), Scale(), Yahtzee())

    fun throws(){
        throwCounter++
        players[0].rollDice()
        val dice : List<LockableDie> = players[0].dice
        printDice(dice)

        println("Write index of dice you would like to lock (0 if none): ")
        val lockedStrings = readln()
        val lockedIndices = lockedStrings.split(' ').map { it.toInt() }.toMutableList()
        if(lockedIndices[0] != 0){
            players[0].lockDice(lockedIndices.map { it - 1 })
            println("Locked numbers: ${players[0].getLockedDiceNumbers()}")
        }
        printDice(dice)
        println("Write index of dice you would like to unlock (0 if none): ")
        val unlockedStrings = readln()
        val unlockedIndices = unlockedStrings.split(' ').map { it.toInt() }
        if(unlockedIndices[0] != 0){
            players[0].unlockDice(unlockedIndices.map { it - 1 })
        }
        /*
        unlockedIndices.forEach { number ->
            if(lockedIndices.contains(number)){
                lockedIndices.remove(number)
            }
        */
        println("Locked numbers: ${players[0].getLockedDiceNumbers()}")
        println("Write 1 to throw again or 0 to choose a combination: ")
        }

    fun play(){
        println("PLAYER 1")
        println("Press enter to play: ")
        readln()
        repeat(3){
            throws()
            val decision = readln()
            when (decision) {
                "0" -> {
                    getCombination()
                    return@repeat
                }
            }
        }
    }

    fun printDice(dice: List<LockableDie>){
        println(dice.joinToString {
            if (it.locked) {
                "{" + it.number.toString() + "}"
            } else {
                it.number.toString()
            }
        })
    }

    fun getCombination(){

    }
}


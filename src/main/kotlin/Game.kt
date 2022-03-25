import combinations.*

class Game {

    private var player = Player()

    private fun lock(){
        var lockedIndices: List<Int> = emptyList()
        do{
            println("Write index of dice you would like to lock (0 if none): ")
            val lockedStrings = readln()
            val success = try{
                lockedIndices = lockedStrings.split(' ').map { it.toInt() }.toMutableList()
                lockedIndices.none { it !in 0..6 }
            }
            catch (e: Throwable){
                false
            }
        }while (!success)

        if(lockedIndices[0] != 0){
            player.lockDice(lockedIndices.map { it - 1 })
            println("Locked numbers: ${player.getLockedDiceNumbers()}")
        }
    }

    private fun unlock(){
        var unlockedIndices: List<Int> = emptyList()
        do{
            println("Write index of dice you would like to unlock (0 if none): ")
            val unlockedStrings = readln()
            val success = try{
                unlockedIndices = unlockedStrings.split(' ').map { it.toInt() }
                unlockedIndices.none { it !in 0..6 }
            }
            catch (e: Throwable){
                false
            }
        }while (!success)

        if(unlockedIndices[0] != 0){
            player.unlockDice(unlockedIndices.map { it - 1 })
        }
    }

    private fun throwDice(){
        player.rollDice()
        val dice : List<LockableDie> = player.dice
        printDice(dice)
        lock()
        printDice(dice)
        unlock()
        println("Locked numbers: ${player.getLockedDiceNumbers()}")
    }

    fun play(){
        println("Press enter to play: ")
        readln()
        while(player.card.points.size < 3) {
            for (i in 0 until 3) {
                throwDice()
                if (i == 2) {
                    println("Write 0 to choose a combination: ")
                } else {
                    println("Write 1 to throw again or 0 to choose a combination: ")
                }

                when (readln()) {
                    "0" -> {
                        getCombination()
                        player.unlockDice(listOf(0,1,2,3,4,5))
                        break
                    }
                    "1" -> continue
                    else -> {
                        println("Invalid input. Try again: ")
                    }
                }
            }
        }
        println(player.card.points)
    }

    private fun printDice(dice: List<LockableDie>){
        println(dice.joinToString {
            if (it.locked) {
                "{" + it.number.toString() + "}"
            } else {
                it.number.toString()
            }
        })
    }

    private fun getCombination(){
        var written = false
        while (!written) {
            println("1. Poker \n2. Scale \n3. Yahtzee \n")
            println("Write a number of the wanted combination: ")
            val entry = try {
                readln().toInt()
            } catch (e: Throwable) {
                continue
            }

            val category = when (entry) {
                1 -> Category.POKER
                2 -> Category.SCALE
                3 -> Category.YAHTZEE
                else -> continue
            }

            written = player.writePoints(category)
            if (written) {
                val points = player.card.getPoints(category)
                println("Points earned: $points")
            }
        }
    }
}


import combinations.*

class Game {

    private var player = Player()

    private fun lock(){
        println("Write index of dice you would like to lock (0 if none): ")
        val lockedStrings = readln()
        val lockedIndices = lockedStrings.split(' ').map { it.toInt() }.toMutableList()
        if(lockedIndices[0] != 0){
            player.lockDice(lockedIndices.map { it - 1 })
            println("Locked numbers: ${player.getLockedDiceNumbers()}")
        }
    }

    private fun unlock(){
        println("Write index of dice you would like to unlock (0 if none): ")
        val unlockedStrings = readln()
        val unlockedIndices = unlockedStrings.split(' ').map { it.toInt() }
        if(unlockedIndices[0] != 0){
            player.unlockDice(unlockedIndices.map { it - 1 })
        }
    }

    private fun throws(){
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
                throws()
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

            val category = when (readln().toInt()) {
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


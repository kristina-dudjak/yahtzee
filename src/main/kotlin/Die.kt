import kotlin.random.Random

open class Die {

    var number: Int = 0

    open fun rollDie() {
        number = Random.nextInt(1, 7)
    }

}
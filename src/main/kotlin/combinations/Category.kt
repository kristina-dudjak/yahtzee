package combinations

enum class Category(
    val combination: Combination
) {
    POKER(Poker()), SCALE(Scale()), YAHTZEE(Yahtzee())
}
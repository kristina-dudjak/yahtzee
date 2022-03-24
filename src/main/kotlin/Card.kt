import combinations.Category

class Card {

    private var points = mutableMapOf<Category, Int>()

    fun writeScore(category: Category, score: Int){
        points[category] = score
    }
}
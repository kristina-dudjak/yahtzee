import combinations.Category

class Card {

    var points = mutableMapOf<Category, Int>()

    fun writeScore(category: Category, score: Int){
        points[category] = score
    }

    fun containsCategory(key: Category) : Boolean{
        return points.containsKey(key)
    }

    fun getPoints(category: Category): Int?{
        return points[category]
    }
}
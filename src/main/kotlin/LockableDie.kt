
class LockableDie : Die() {

    var locked : Boolean = false

    override fun rollDie() {
        if(!locked){
            super.rollDie()
        }
    }
}
package easySubjectNoClassify

class FindDelayedArrivalTime {
    fun findDelayedArrivalTime(arrivalTime: Int, delayedTime: Int): Int {
        return (arrivalTime + delayedTime) % 24
    }
}
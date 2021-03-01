package sinoptik.teacher.mishanya

interface ITask {

    val result: Double

    fun point() = 1.0

    fun generateDescription(): String
}
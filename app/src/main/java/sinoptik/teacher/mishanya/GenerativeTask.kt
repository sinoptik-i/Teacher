package sinoptik.teacher.mishanya

class GenerativeTask(
        val formula: String,
        val variables: List<Pair<String, Number>>
) : ITask {

    override val result: Double
        get() = 0.0

    override fun generateDescription(): String {
//        TODO("Not yet implemented")
        return ""
    }
}
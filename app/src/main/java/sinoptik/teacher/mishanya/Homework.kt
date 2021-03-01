package sinoptik.teacher.mishanya

data class Homework(
        private val tasks: List<ITask>
) {

    val allPoints by lazy { tasks.sumByDouble { it.point() } }

    fun generate(): String = tasks.mapIndexed { index, task ->
        """
                Задание $index.
                 ${task.generateDescription()}
            """.trimIndent()
    }.joinToString(separator = "\n", prefix = "Домашнее задание \n")


    fun check(vararg answers: Double?): String {
        assert(answers.size == tasks.size)
        tasks.map { task -> task.result }
        val result = tasks.mapIndexed { index, task ->
            if (answers[index] == task.result) task.point() else 0.0
        }.sum()
        return "Ты набрал $result из возможных $allPoints"
    }

    companion object {
        fun eee() {
            val homework = Homework(listOf(
                    AdditionTask(1, 2),
                    AdditionTask(3, 4),
                    AdditionTask(5, 6),
                    GenerativeTask("ax^2+bx+c", listOf(
                            "a" to 2.0,
                            "b" to 5.0,
                            "c" to 12.0
                    ))
            ))

            val description = homework.generate()

            homework.check(3.0, 5.0, null, 8.0)
        }
    }
}
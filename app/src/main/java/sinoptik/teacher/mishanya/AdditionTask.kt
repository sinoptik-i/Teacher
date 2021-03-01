package sinoptik.teacher.mishanya

class AdditionTask(val numberOne: Number,
                   val numberTwo: Number) : ITask {

    override val result: Double
        get() = numberOne.toDouble() + numberTwo.toDouble()

    override fun generateDescription(): String = """
        Вычислите сумму чисел $numberOne и $numberTwo
    """
}
package conventions

class Invokable {
    private var numberOfInvocations: Int = 0

    operator fun invoke(): Invokable {
        numberOfInvocations++
        return this
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()
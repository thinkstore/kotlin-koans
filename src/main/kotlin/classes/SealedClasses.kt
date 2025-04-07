package classes

fun eval2(expr: Expr2): Int =
    when (expr) {
        is Num2 -> expr.value
        is Sum2 -> eval(expr.left) + eval(expr.right)
    }

sealed interface Expr2
class Num2(val value: Int) : Expr2
class Sum2(val left: Expr, val right: Expr) : Expr2
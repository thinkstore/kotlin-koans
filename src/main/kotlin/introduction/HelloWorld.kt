package introduction
fun joinOptions(options: Collection<String>) =
    options.joinToString(prefix="[" , postfix="]")

fun main(){
    println( joinOptions( listOf("a", "b", "c") ))
}
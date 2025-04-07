package org.example.collections

fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {

    val groupsByLength = collection.groupBy { s -> s.length }

    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.maxOrNull()

    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}

fun main(){
    val test = listOf("blue" , "red" , "brown" , "green" , "cyan" , "black" )
    val groupsByLength = test.groupBy { s -> s.length }
    println(groupsByLength)

    val maximumSizeOfGroup = groupsByLength.values.map{ group -> group.size }.maxOrNull()
    println(maximumSizeOfGroup)

    val sth = groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
    println(sth)

    println( doSomethingWithCollection(test))
}
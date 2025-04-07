package org.example

//import addTimeIntervals
import java.lang.Integer.sum
import java.util.*
import kotlin.NoSuchElementException

// Implement the function that checks whether a string is a valid identifier.
// A valid identifier is a non-empty string that starts with a letter or
// underscore and consists of only letters, digits and underscores.

private val validFirstChars =  ('a'..'z') + ('A' .. 'Z') + '_'
private val validChars =  validFirstChars + ('0' .. '9')

fun isValidIdentifier(s: String) : Boolean {
    return s.isNotEmpty() &&
            s.first() in validFirstChars &&
            s.drop(1).all { it in  validChars }
}

/*

Change the 'sum' function so that it was declared as an extension to List<Int>.
fun sum(list: List<Int>): Int {
    var result = 0
    for (i in list) {
        result += i
    }
    return result
}
*/

fun List<Int>.sum() : Int {
    var result : Int = 0
    for ( i in this ){
        result += i
    }
    return result
}

fun compare(left : String , right : String ) : Pair<Int,List<Char>> {
    val limit = if( left.length < right.length ) left.length else right.length
    val matched = mutableListOf<Char>()
    for( i in 0 until limit) {
        if( left[i] == right[i])
            matched.add(left[i])
    }
    return matched.count() to matched
}
/*
Fail: testIterateOverDateRange: Incorrect iteration over the following dates:
expected:<[
MyDate(year=2016, month=5, dayOfMonth=1),
MyDate(year=2016, month=5, dayOfMonth=2),
MyDate(year=2016, month=5, dayOfMonth=3),
MyDate(year=2016, month=5, dayOfMonth=4),
MyDate(year=2016, month=5, dayOfMonth=5)]>

but was:<
[
MyDate(year=2016, month=5, dayOfMonth=1),
MyDate(year=2016, month=5, dayOfMonth=2),
MyDate(year=2016, month=5, dayOfMonth=3),
MyDate(year=2016, month=5, dayOfMonth=4)]>
 */



// Supported intervals that might be added to dates:
/*
enum class TimeInterval { DAY, WEEK, YEAR }

data class RepeatedTimeInterval( val timeInterval: TimeInterval , val count : Int )

operator fun TimeInterval.times(count : Int ) = RepeatedTimeInterval(this , count)

operator fun MyDate.plus( repeatedTimeInterval: RepeatedTimeInterval): MyDate {
    val calendar = Calendar.getInstance()
    calendar.set( this.year , this.month , this.dayOfMonth )
    when( repeatedTimeInterval.timeInterval ){
        TimeInterval.DAY -> calendar.add(Calendar.DAY_OF_MONTH , repeatedTimeInterval.count )
        TimeInterval.WEEK -> calendar.add(Calendar.WEEK_OF_YEAR , repeatedTimeInterval.count)
        TimeInterval.YEAR -> calendar.add(Calendar.YEAR , repeatedTimeInterval.count)
    }

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.WEEK_OF_YEAR)
    val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
    return MyDate(year , month , dayOfMonth)
}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this + RepeatedTimeInterval( timeInterval , 1 )
}

fun task1(today: MyDate): MyDate {
    return today + TimeInterval.YEAR + TimeInterval.WEEK
}

fun task2(today: MyDate): MyDate {
 return today + TimeInterval.YEAR * 2 + TimeInterval.WEEK * 3 + TimeInterval.DAY * 5
}

*/


fun main() {

   // iterateOverDateRange(firstDate , lastDate ){
   //     println( it )
   // }
//    println(task1(firstDate))
//    println(task2(firstDate))


    /*
        println(isValidIdentifier("name"))   // true
        println(isValidIdentifier("_name"))  // true
        println(isValidIdentifier("_12"))    // true
        println(isValidIdentifier(""))       // false
        println(isValidIdentifier("012"))    // false
        println(isValidIdentifier("no$"))    // false
        val sum = listOf(1, 2, 3).sum()
        println(sum)
    */
    println( compare("abcd" , "axcy") )
}
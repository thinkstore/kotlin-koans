package conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo( other : MyDate ) : Int {
        if( year < other.year )
            return -1

        if( year > other.year )
            return 1

        if( month < other.month )
            return -1

        if( month > other.month )
            return 1

        if( dayOfMonth < other.dayOfMonth )
            return -1

        if( dayOfMonth > other.dayOfMonth )
            return 1

        return 0

    }
}

fun MyDate.followingDate() : MyDate {
    val c = Calendar.getInstance()
    c.set( this.year , this.month , this.dayOfMonth )
    val millisecondsInADay = 24 * 60 * 60 * 1000L
    val timeInMilliseconds = c.timeInMillis + millisecondsInADay
    val result = Calendar.getInstance()
    result.timeInMillis = timeInMilliseconds
    return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DAY_OF_MONTH))
}

fun MyDate.toMillis() : Long {
    val calendar = Calendar.getInstance()
    calendar.set( year , month , dayOfMonth)
    return calendar.timeInMillis
}

fun Long.toMyDate() : MyDate {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return MyDate( calendar.get(Calendar.YEAR) , calendar.get(Calendar.MONTH) , calendar.get(Calendar.DAY_OF_MONTH))
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)



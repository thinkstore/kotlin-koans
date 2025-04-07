package conventions

import java.util.Calendar

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
    val month = calendar.get(Calendar.MONTH)
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
    return today + TimeInterval.YEAR * 2 +  TimeInterval.WEEK * 3 + TimeInterval.DAY * 5
}
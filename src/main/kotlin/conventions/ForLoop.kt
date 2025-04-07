package conventions

class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var curDate = start
            override fun hasNext(): Boolean {
                return curDate <= end
            }

            override fun next(): MyDate {
                val returnDate = curDate
                curDate = curDate.followingDate()
                return returnDate
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
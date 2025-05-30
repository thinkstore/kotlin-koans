package org.example.properties

import conventions.MyDate
import conventions.toMillis
import conventions.toMyDate
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    private var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        return timeInMillis!!.toMyDate()
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        timeInMillis = value.toMillis()
    }
}
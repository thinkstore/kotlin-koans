class LazyProperty(val initializer: () -> Int) {
    private var _lazy : Int? = null
    val lazy: Int
        get() {
            if( _lazy == null )
                _lazy = initializer()
            return _lazy!!
        }
}

class ThreadSafeLazyProperty( val initializer: () -> Int ){
    @Volatile private var _lazy : Int? = null
    val lazy:Int
        get() {
            val local = _lazy
            return local ?: synchronized(this) {
                _lazy ?: initializer().also { _lazy = it }
            }
        }
}

fun main() {
    val lazyProp = LazyProperty {
        println("Computing lazy value...")
        43
    }

    println("First Call : ${lazyProp.lazy}")
    println("Second Call : ${lazyProp.lazy}")

    val threadSafeLazyProperty = ThreadSafeLazyProperty {
        println("Computing lazy value...")
        43
    }

    println("First Call : ${threadSafeLazyProperty.lazy}")
    println("Second Call : ${threadSafeLazyProperty.lazy}")

}
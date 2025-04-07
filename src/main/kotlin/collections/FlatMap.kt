package collections

// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> = orders.flatMap { it.products }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =  customers.flatMap { customer -> customer.orders.flatMap { it.products } }.toSet()

fun main() {
    println( testShop.customers.flatMap { customer -> customer.orders.flatMap { it.products } }.toSet() )
}


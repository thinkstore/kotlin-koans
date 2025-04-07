package org.example.collections

import collections.Customer
import collections.Product
import collections.Shop
import collections.testShop

// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders.filter { it.isDelivered }.flatMap { it.products }.maxByOrNull { it.price }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap { it.orders }.flatMap { it.products }.count { it == product }
}



fun main() {
    val product = findMostExpensiveProductBy( testShop.customers[1] )
    println(product)

    product?.let {
        val count = testShop.getNumberOfTimesProductWasOrdered(product)
        println(count)
    }

}

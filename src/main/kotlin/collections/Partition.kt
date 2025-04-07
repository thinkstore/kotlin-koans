package org.example.collections

import collections.Customer
import collections.Shop
import collections.testShop

// Return customers who have more undelivered orders than delivered

fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.filter { customer ->
    val ( matched , rest ) = customer.orders.partition { it.isDelivered }
    matched.size > rest.size
}.toSet()

fun main(){
    println( testShop.getCustomersWithMoreUndeliveredOrders() )
}
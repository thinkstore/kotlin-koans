package org.example.collections

import collections.Customer
import collections.Product
import collections.testShop

fun Customer.moneySpentBy() = orders.flatMap { it.products }.sumOf { it.price }

fun main() {
    println( testShop.customers[1].moneySpentBy() )
}
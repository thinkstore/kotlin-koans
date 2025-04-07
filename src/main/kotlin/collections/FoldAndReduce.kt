package org.example.collections

import collections.Customer
import collections.Product
import collections.Shop
import collections.testShop

// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> = customers
    .map{ customer -> customer.orders.flatMap{ it.products }.toSet() }
    .reduce{ acc , products -> acc.intersect(products) }

fun Customer.getOrderedProducts(): Set<Product> = orders.flatMap { it.products }.toSet()

fun main() {

    val allCustomerProducts = testShop.customers.map { customer -> customer.orders.flatMap { it.products }.toSet() }
    println(allCustomerProducts)

    val commonProducts = allCustomerProducts.reduce{ acc , products -> acc.intersect(products) }
    println(commonProducts)

}
package collections

val testShop = Shop(
    name = "SuperMart",
    customers = listOf(
        Customer(
            name = "Alice Johnson",
            city = City("New York"),
            orders = listOf(
                Order(
                    products = listOf(
                        Product("Laptop", 999.99),
                        Product("Mouse", 25.50)
                    ),
                    isDelivered = true
                ),
                Order(
                    products = listOf(
                        Product("Keyboard", 75.00)
                    ),
                    isDelivered = false
                )
            )
        ),
        Customer(
            name = "Bob Smith",
            city = City("Chicago"),
            orders = listOf(
                Order(
                    products = listOf(
                        Product("Smartphone", 799.99),
                        Product("Case", 15.99),
                        Product("Screen Protector", 9.99),
                        Product("Laptop", 999.99),
                    ),
                    isDelivered = true
                )
            )
        ),
        Customer(
            name = "Carol Williams",
            city = City("Boston"),
            orders = listOf(
                Order(
                    products = listOf(
                        Product("Headphones", 149.99),
                        Product("USB Cable", 12.50)
                    ),
                    isDelivered = false
                ),
                Order(
                    products = listOf(
                        Product("Laptop", 999.99),
                        Product("Tablet", 299.99)
                    ),
                    isDelivered = true
                ),
                Order(
                    products = listOf(
                        Product("Charger", 29.99),
                        Product("Battery Pack", 39.99)
                    ),
                    isDelivered = false
                )
            )
        ),
        Customer(
            name = "David Brown",
            city = City("New York"),
            orders = listOf(
                Order(
                    products = listOf(
                        Product("Laptop", 999.99)
                    ),
                    isDelivered = false
                )
            )  // Customer with no orders
        )
    )
)
object q1{
    var items: Array[String] = Array("item 1", "item 2", "item 3")
    var quantities: Array[Int] = Array(23,34,53)

    def displayInventory(items: Array[String], quantities: Array[Int]): Unit = {
        for((item, quantity) <- items.zip(quantities)){
            println(s"Item: $item, Quantity: $quantity")
        }
    }

    def restockItem(names: Array[String], quantities: Array[Int], itemName: String, quantity: Int): Unit = {
        val index = names.indexOf(itemName)
        if (index >= 0){
            quantities(index) += quantity
            println(s"Restocked $quantity $itemName(s). New quantity: ${quantities(index)}")
        }else{
            println(s"Item $itemName does not exist in the inventory.")
        }
    }

    def sellItem(names: Array[String], quantities: Array[Int], itemName: String, quantity: Int): Unit = {
        val index = names.indexOf(itemName)
        if (index >= 0){
            if (quantities(index) >= quantity){
                quantities(index) -= quantity
                println(s"Sold $quantity $itemName(s). Remaining quantity: ${quantities(index)}")
            }else{
                println(s"Not enough $itemName in stock to sell. Available quantity: ${quantities(index)}")
            }
        }else{
            println(s"Item $itemName does not exist in the inventory.")
        }
    }

    def main(args: Array[String]): Unit={
        displayInventory(items, quantities)
        restockItem(items, quantities, "item 1", 5)
        sellItem(items, quantities, "item 2", 15)
        displayInventory(items, quantities)
    }
}
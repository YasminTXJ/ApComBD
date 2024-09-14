
package com.example.inventory.data
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */
import androidx.room.Entity

/** MODEL DO ITEM
 */
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Double,
    val quantity: Int
)

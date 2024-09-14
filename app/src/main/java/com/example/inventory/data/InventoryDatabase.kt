package com.example.inventory.data

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room

/**
 *Instancia um banco de dados
 */
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    //acesso aos métodos criar ou acessar o banco de dados e usa o nome da classe como qualificador.
    companion object {
        @Volatile
        private var Instance: InventoryDatabase? = null

//builder de banco de dados para acessar o banco de dados.

        fun getDatabase(context: Context): InventoryDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                //o bloco synchronized, use o builder do banco de dados para acessar um banco de dados. Transmita o contexto do aplicativo, a classe do banco de dados e um nome para o banco de dados, item_database para Room.databaseBuilder().
                Room.databaseBuilder(context, InventoryDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
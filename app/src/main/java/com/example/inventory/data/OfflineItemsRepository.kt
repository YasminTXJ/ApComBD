

package com.example.inventory.data

import ItemsRepository
import kotlinx.coroutines.flow.Flow

/**
 * A interface ItemsRepository define um conjunto de métodos para realizar operações CRUD (Create, Read, Update, Delete).
 * A classe OfflineItemsRepository implementa essa interface e delega essas operações
 * para o DAO (ItemDao), que interage diretamente com a fonte de dados, provavelmente
 * um banco de dados local.
 */
class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)
}
/**
 * O uso de Flow permite que o aplicativo receba atualizações em tempo real sempre
 * que os dados no banco de dados forem alterados.
 *
 *
 *
 *
 *  aplicativo que trabalha offline, ou seja, sem a necessidade de uma conexão com a internet, e os dados são armazenados
 *  localmente no dispositivo usando Room ou algum outro mecanismo de persistência local.
 */
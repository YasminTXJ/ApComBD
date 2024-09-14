package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Interface com o Banco de Dados
 * Flow no banco de dados do Room pode manter os dados atualizados emitindo
 * uma notificação sempre que os dados no banco de dados mudarem. Isso permite observar
 * os dados e atualizar a interface corretamente.
 * Essa configuração é útil para atualizar a lista de inventário. Devido ao tipo de retorno Flow,
 * o Room também executa a consulta na linha de execução em segundo plano.
 * Não é necessário transformar o fluxo em uma função suspend explicitamente e chamá-lo dentro de
 * um escopo de corrotina.
 */
/**
 *  interface que define as operações de acesso a dados (DAO) para a tabela items no banco de dados .
 */
@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}

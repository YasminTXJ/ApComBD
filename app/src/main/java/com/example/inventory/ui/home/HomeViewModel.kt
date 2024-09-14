

package com.example.inventory.ui.home

import ItemsRepository
import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * ViewModel que gerencia o estado da UI da tela inicial (HomeScreen)
 * Ela interage com o repositório de itens (ItemsRepository) para buscar os dados
 * e preparar o estado da interface do usuário.
 */
class HomeViewModel(itemsRepository: ItemsRepository): ViewModel() {
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUiState: StateFlow<HomeUiState> =
        itemsRepository.getAllItemsStream().map { HomeUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )
}

/**
 * Ui State for HomeScreen
 */
data class HomeUiState(val itemList: List<Item> = listOf())

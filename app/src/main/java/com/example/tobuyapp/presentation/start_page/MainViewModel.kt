package com.example.tobuyapp.presentation.start_page

import androidx.lifecycle.ViewModel
import com.example.tobuyapp.data.ShopListRepositoryImpl
import com.example.tobuyapp.domain.entity.ShopItem
import com.example.tobuyapp.domain.usecases.DeleteShopItemUseCase
import com.example.tobuyapp.domain.usecases.EditShopItemUseCase
import com.example.tobuyapp.domain.usecases.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopListUseCase.deleteShopItem(shopItem = shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newShopItem)
    }
}
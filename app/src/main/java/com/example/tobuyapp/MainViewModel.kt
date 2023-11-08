package com.example.tobuyapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.ShopListRepositoryImpl
import com.example.domain.entity.ShopItem
import com.example.domain.usecases.DeleteShopItemUseCase
import com.example.domain.usecases.EditShopItemUseCase
import com.example.domain.usecases.GetShopListUseCase

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem = shopItem)
        getShopList()
    }

    fun changeEnableShopItemState(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(shopItem = newShopItem)
        getShopList()
    }
}
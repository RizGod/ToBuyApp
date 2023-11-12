package com.example.tobuyapp.domain.usecases

import com.example.tobuyapp.domain.entity.ShopItem
import com.example.tobuyapp.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem = shopItem)
    }
}
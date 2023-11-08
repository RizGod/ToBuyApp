package com.example.domain.usecases

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem = shopItem)
    }
}
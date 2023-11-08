package com.example.domain.usecases

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem = shopItem)
    }
}
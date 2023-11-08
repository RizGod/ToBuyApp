package com.example.domain.usecases

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem = shopItem)
    }
}
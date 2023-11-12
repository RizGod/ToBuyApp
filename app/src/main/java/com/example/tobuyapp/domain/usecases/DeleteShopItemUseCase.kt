package com.example.tobuyapp.domain.usecases

import com.example.tobuyapp.domain.entity.ShopItem
import com.example.tobuyapp.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem = shopItem)
    }
}
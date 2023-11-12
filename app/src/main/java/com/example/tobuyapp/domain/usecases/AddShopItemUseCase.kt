package com.example.tobuyapp.domain.usecases

import com.example.tobuyapp.domain.entity.ShopItem
import com.example.tobuyapp.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem = shopItem)
    }
}
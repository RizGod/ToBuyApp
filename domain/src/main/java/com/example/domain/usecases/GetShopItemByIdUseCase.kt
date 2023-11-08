package com.example.domain.usecases

import com.example.domain.entity.ShopItem
import com.example.domain.repository.ShopListRepository

class GetShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemById(id: Int): ShopItem {
        return shopListRepository.getShopItemById(id = id)
    }
}
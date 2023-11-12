package com.example.tobuyapp.domain.usecases

import com.example.tobuyapp.domain.entity.ShopItem
import com.example.tobuyapp.domain.repository.ShopListRepository

class GetShopItemByIdUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemById(id: Int): ShopItem {
        return shopListRepository.getShopItemById(id = id)
    }
}
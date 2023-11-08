package com.example.domain.usecases

import com.example.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(id: Int) {
        shopListRepository.deleteShopItem(id = id)
    }
}
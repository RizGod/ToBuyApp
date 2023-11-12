package com.example.tobuyapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.tobuyapp.domain.entity.ShopItem
import com.example.tobuyapp.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}
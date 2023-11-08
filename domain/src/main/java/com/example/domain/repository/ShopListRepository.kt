package com.example.domain.repository

import com.example.domain.entity.ShopItem

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(id: Int)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItemById(id: Int): ShopItem

    fun getShopList(): List<ShopItem>
}
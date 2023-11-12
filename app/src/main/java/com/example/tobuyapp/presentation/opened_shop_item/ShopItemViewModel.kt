package com.example.tobuyapp.presentation.opened_shop_item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tobuyapp.data.ShopListRepositoryImpl
import com.example.tobuyapp.domain.entity.ShopItem
import com.example.tobuyapp.domain.usecases.AddShopItemUseCase
import com.example.tobuyapp.domain.usecases.EditShopItemUseCase
import com.example.tobuyapp.domain.usecases.GetShopItemByIdUseCase

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemByIdUseCase = GetShopItemByIdUseCase(repository)
    private val addShopItemByIdUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getShopItemById(id: Int) {
        val item = getShopItemByIdUseCase.getShopItemById(id = id)
        _shopItem.value = item
    }

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName = inputName)
        val count = parseCount(inputCount = inputCount)
        val fieldsValid = validateInput(name = name, count = count)
        if (fieldsValid) {
            val shopItem = ShopItem(name = name, count = count, enabled = true)
            addShopItemByIdUseCase.addShopItem(shopItem = shopItem)
            finishWork()
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName = inputName)
        val count = parseCount(inputCount = inputCount)
        val fieldsValid = validateInput(name = name, count = count)
        if (fieldsValid) {
            _shopItem.value?.let {
                val item = it.copy(name = name, count = count)
                editShopItemUseCase.editShopItem(shopItem = item)
                finishWork()
            }

        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: Exception) {
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (count <= 0) {
            _errorInputCount.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    fun resetErrorInputCount() {
        _errorInputCount.value = false
    }

    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}
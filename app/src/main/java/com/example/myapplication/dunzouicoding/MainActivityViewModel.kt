package com.example.myapplication.dunzouicoding

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _itemListLiveData: MutableLiveData<List<Item>> = MutableLiveData()
    val itemListLiveData: LiveData<List<Item>> = _itemListLiveData
    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun fetchTheListOfItem(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            _loading.postValue(true)
            val rawString = Util.parseJson(context)
            val itemList = Util.getItemListFromJson(rawString)
            _itemListLiveData.postValue(itemList)
            _loading.postValue(false)
        }
    }
}
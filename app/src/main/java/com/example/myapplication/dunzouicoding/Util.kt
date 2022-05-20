package com.example.myapplication.dunzouicoding

import android.content.Context
import com.example.myapplication.R
import com.google.gson.Gson

object Util {
    fun parseJson(context: Context): String {
        return context.resources.openRawResource(R.raw.product_list).bufferedReader()
            .use { it.readText() }
    }

    fun getItemListFromJson(json: String): List<Item> {
        val result = Gson().fromJson(json, ItemResult::class.java)
        return result.items.product_list
    }
}
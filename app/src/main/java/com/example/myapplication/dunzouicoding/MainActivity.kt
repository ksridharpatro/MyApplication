package com.example.myapplication.dunzouicoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMain2Binding


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMain2Binding
    private lateinit var itemRecyclerAdapter: ItemRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerAdapter()
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.itemListLiveData.observe(this) {
            itemRecyclerAdapter.submitList(it)
        }
        viewModel.loading.observe(this) {

        }
        viewModel.fetchTheListOfItem(application)
    }

    private fun setupRecyclerAdapter() {
        itemRecyclerAdapter = ItemRecyclerAdapter()
        binding.itemRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.itemRecyclerView.adapter = itemRecyclerAdapter
    }
}
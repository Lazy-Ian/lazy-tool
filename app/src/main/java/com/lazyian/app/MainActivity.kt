package com.lazyian.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lazyian.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var vm: MainViewModel
    val mAdapter: TestAdapter by lazy { TestAdapter(arrayListOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this)[MainViewModel::class.java]

        setContentView(binding.root)
        initView()
        initObserver()
    }

    fun initView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerView.adapter = mAdapter

        vm.adapterData.value = vm.testList
    }

    fun initObserver() {

        vm.adapterData.observe(this) {
            mAdapter.setDataList(it)
        }
    }


}
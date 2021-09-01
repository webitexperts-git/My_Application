package com.vsking.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vsking.myapplication.api.apidata.ListData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity(), DataListAdapter.ItemClickListener {
    lateinit var dataListAdapter: DataListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        initViewmodel()
    }
    private fun initViewmodel(){
        val viewmodel = ViewModelProvider(this).get(MainActivityViewmodel::class.java)
        lifecycleScope.launchWhenCreated {
            viewmodel.getListData().collectLatest {
                dataListAdapter.submitData(it)
            }
        }
    }

    private fun setupRecyclerView(){
        rvDataList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            dataListAdapter= DataListAdapter(this@MainActivity)
            adapter=dataListAdapter
        }
    }

    override fun onItemClick(data: ListData) {
        Toast.makeText(this,""+data.name,Toast.LENGTH_LONG).show()
        val intent: Intent= Intent(this,DetailActivity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
    }
}
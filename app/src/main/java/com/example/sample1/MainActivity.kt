package com.example.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private lateinit var adapter : LogRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.stepCountList.observe(this, Observer {list ->
            list?.let {
                adapter.setList(it)
            }
        })

        log_list.layoutManager = LinearLayoutManager(this)
        adapter = LogRecyclerAdapter(viewModel.stepCountList.value!!)
        log_list.adapter = adapter

        val decor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        log_list.addItemDecoration(decor)

        InputDialogFragment().show(supportFragmentManager, "INPUT_TAG")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.add_record -> {
                InputDialogFragment().show(supportFragmentManager, "INPUT_TAG")
                true
            }
            else -> false
        }
    }
}

package com.example.hi.architecturecomponents.view

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.example.hi.architecturecomponents.R.layout
import com.example.hi.architecturecomponents.model.Counter
import com.example.hi.architecturecomponents.model.UserViewModel
import kotlinx.android.synthetic.main.activity_main.btnDown
import kotlinx.android.synthetic.main.activity_main.btnDown1
import kotlinx.android.synthetic.main.activity_main.btnUp
import kotlinx.android.synthetic.main.activity_main.btnUp1
import kotlinx.android.synthetic.main.activity_main.tvCount
import kotlinx.android.synthetic.main.activity_main.tvCount1

class MainActivity : LifecycleActivity() {

    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        Log.d(TAG, "onCreate")

        /**
         * Normal Data
         */
        val counter = Counter()
        counter.getCount().subscribe {
            Log.d(TAG, it.toString())
            tvCount.text = it.toString()
        }

        btnUp.setOnClickListener { counter.increase() }
        btnDown.setOnClickListener { counter.decrease() }

        /**
         * ViewModel & RxJava Data
         */
        val viewModel: UserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.getCount().subscribe {
            Log.d(TAG, it.toString())
            tvCount1.text = it.toString()
        }

        btnUp1.setOnClickListener { viewModel.increase() }
        btnDown1.setOnClickListener { viewModel.decrease() }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}

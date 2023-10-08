package com.example.bhp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import com.example.bhp.R
import com.example.bhp.databinding.ActivityMainBinding
import com.example.bhp.network.MyViewModelFactory
import com.example.bhp.network.Repo
import com.example.bhp.ui.model.RequestPredectHomePrice
import com.example.bhp.ui.viewmodel.HomeViewModel
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: HomeViewModel
    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,  MyViewModelFactory(Repo(this),this)).get(HomeViewModel::class.java) // view model creation

        /*val tietArea: TextInputEditText = findViewById(R.id.tietArea)
        val spBHK: Spinner = findViewById(R.id.spBHK)
        val spBath: Spinner = findViewById(R.id.spBath)
        val spLocation: Spinner = findViewById(R.id.spLocation)
        val btnEstimatePrice: Button = findViewById(R.id.btnEstimatePrice)*/

        bindData()

        binding.btnEstimatePrice.setOnClickListener(View.OnClickListener {

            var params= RequestPredectHomePrice(binding.tietArea.toString(),
                binding.spBHK.selectedItem as String?, binding.spLocation.selectedItem as String?,
                binding.spBath.selectedItem as String?)
            viewModel.predict_home_price(params).observe(this){
                binding.tvEstimatedPrice.text="Estimated Price: ${it.estimatedPrice}"
            }
        })


    }

    private fun bindData() {

        val itemList = listOf("1", "2", "3", "4")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spBHK.adapter = adapter
        binding.spBath.adapter = adapter

        binding.spBath.selectedItem


        viewModel.get_location_names()

        viewModel.responseGetLocations.observe(this) {

            val adapterLocation =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, it.locations!!)
            adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spLocation.adapter = adapterLocation
        }

        /*viewModel.responsePrice.observe(this){
            binding.tvEstimatedPrice.text="Estimated Price: ${it.estimatedPrice}"
        }*/
    }
}
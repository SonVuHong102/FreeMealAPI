package com.zagon102.freemealapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.zagon102.freemealapi.databinding.ActivityMainBinding
import com.zagon102.freemealapi.meal.MealViewModel
import com.zagon102.freemealapi.network.Api
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    private val viewModel: MealViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val toolbar = binding.toolbar
//        setSupportActionBar(toolbar)
//
//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.navController
//
//        val drawerLayout = binding.drawerLayout
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.meal_dest),drawerLayout)
//        setupActionBarWithNavController(navController,appBarConfiguration)
            test()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
     fun test() {
        lifecycleScope.launch {
            makeToast(Api.retrofitService.get())
        }
    }
    fun makeToast(testStr: String) {

        Toast.makeText(this,testStr,Toast.LENGTH_SHORT).show()
    }

}
package com.example.chadifierapp2

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.chadifierapp2.data.user_profile.UserDataRepository
import com.example.chadifierapp2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    initiate the repositories
    val userDataRepository = UserDataRepository("Nicolas")

//    getter and setters for repositories -----------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.d("THIS_MAIN_ACTIVITY", this.toString())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_new_task,
                R.id.navigation_list_prev_tasks,
                R.id.navigation_user_profile,
                R.id.navigation_task_added
            )
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val toolbarTitle: TextView = findViewById(R.id.toolbar_title)
        toolbarTitle.text = "Home"

        // Set the navigation icon
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbarTitle.text = destination.label
            toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)

        }




    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val navController: NavController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)
                navController.navigateUp() || super.onOptionsItemSelected(item)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
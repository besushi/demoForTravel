package com.example.test.Activitys.Activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.example.test.Activitys.Fragments.Concerts_fragment
import com.example.test.Activitys.Fragments.Flights_fragment
import com.example.test.Activitys.Fragments.Leisure_fragments
import com.example.test.Activitys.Fragments.Vacations_fragment
import com.example.test.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.framelayout, Flights_fragment()
            ).commit()

            val navView: NavigationView = findViewById(R.id.nav_view)
            navView.setNavigationItemSelectedListener { menuItem ->


                var selectedFragment: Fragment? = null

                when (menuItem.itemId) {
                    R.id.flights -> selectedFragment = Flights_fragment()
                    R.id.vacation -> selectedFragment = Vacations_fragment()
                    R.id.concerts -> selectedFragment = Concerts_fragment()
                    R.id.leisure -> selectedFragment = Leisure_fragments()
                }

                supportFragmentManager.beginTransaction().replace(R.id.framelayout, selectedFragment!!).commit()
                drawerLayout.closeDrawer(GravityCompat.START)
                true
            }
        }
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }









}

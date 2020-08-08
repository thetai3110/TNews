package com.closer.tnews.homepage

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.closer.tnews.R

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var homePageFragment = HomePageFragment()
        supportFragmentManager.beginTransaction().replace(android.R.id.content, homePageFragment).commit()
        var supportActionBar = supportActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
            R.id.search -> { }
            R.id.settings -> { }
        }
        return super.onOptionsItemSelected(item)
    }
}
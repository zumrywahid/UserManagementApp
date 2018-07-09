package userapp.ui.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.view.MenuItem
import androidx.navigation.Navigation
import com.userapp.R
import dagger.android.support.DaggerAppCompatActivity
import userapp.ui.login.LoginActivity

class DashboardActivity : DaggerAppCompatActivity() {

    private var mDrawerLayout: DrawerLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        mDrawerLayout = findViewById(R.id.drawer_layout)
        mDrawerLayout?.setStatusBarBackground(R.color.colorPrimaryDark)

        var navigationView = findViewById<NavigationView>(R.id.nav_view)
        if (navigationView != null) {
            setupDrawerContent(navigationView)
        }

        // Set up the toolbar.
        val toolbar = findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar
        ab!!.setDisplayHomeAsUpEnabled(true)
        ab.setHomeAsUpIndicator(R.drawable.ic_menu)
        ab.setDisplayShowHomeEnabled(true)
        ab.title = "User Dashboard"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.edit_user_menu_item -> {
                }
                R.id.logout_menu_item -> {

                    val intent = Intent(this@DashboardActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> {
                }
            }// Do nothing, we're already on that screen
            // Close the navigation drawer when an item is selected.
            menuItem.isChecked = true
            mDrawerLayout?.closeDrawers()
            true
        }
    }
}

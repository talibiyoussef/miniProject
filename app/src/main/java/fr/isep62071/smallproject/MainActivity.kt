package fr.isep62071.smallproject

import android.content.ContentValues
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Telephony
import android.view.Gravity
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import fr.isep62071.smallproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val handler = Handler(Looper.getMainLooper());
    private lateinit var alertDialogRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var phoneNumber = "+33701010101";
        var message = "I am texting you, please call me.";

        fun sendSMS(phoneNumber: String, message: String) {

                val values = ContentValues().apply {
                    put(Telephony.Sms.ADDRESS, phoneNumber)
                    put(Telephony.Sms.BODY, message)
                }
                contentResolver.insert(Telephony.Sms.Sent.CONTENT_URI, values)
        }

        fun showAlertDialog() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Love reminder")
                .setMessage("You have successfully been loved!")
                .setIcon(R.drawable.ic_launcher_foreground)

            val alertDialog: AlertDialog = builder.create()
            val window = alertDialog.window
            if (window != null) {
                val layoutParams = window.attributes
                layoutParams.gravity = Gravity.BOTTOM
                window.attributes = layoutParams
            }

            alertDialog.show()

            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                if (alertDialog.isShowing) {
                    alertDialog.dismiss()
                }
            }, 2000)
        }
        alertDialogRunnable = object : Runnable {
            override fun run() {
                showAlertDialog()
                handler.postDelayed(this, 20000)
            }
        }
        handler.post(alertDialogRunnable)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            try {
                sendSMS(phoneNumber, message)
                Snackbar.make(view, "Message sent", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            } catch (e: Exception){
                Snackbar.make(view, "Failed to send a message", Snackbar.LENGTH_LONG).setAction("Action", null).show()

            }
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}
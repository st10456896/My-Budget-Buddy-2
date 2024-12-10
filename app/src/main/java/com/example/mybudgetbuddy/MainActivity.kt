import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.mybudgetbuddy.MainActivity2
import com.example.mybudgetbuddy.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide the action bar
        supportActionBar?.hide()

        // Use Handler to delay the transition
        Handler(Looper.getMainLooper()).postDelayed({
            // Start the next activity
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
            finish() // Finish the current activity
        }, 3000) // Delay in milliseconds
    }
}

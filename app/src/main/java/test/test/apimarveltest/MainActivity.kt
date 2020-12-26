package test.test.apimarveltest

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import test.test.apimarveltest.databinding.ActivityMainBinding
import timber.log.Timber
import timber.log.Timber.DebugTree

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    fun showProgressBar(){
        binding.mainProgressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar(){
        binding.mainProgressBar.visibility = View.INVISIBLE

    }
}
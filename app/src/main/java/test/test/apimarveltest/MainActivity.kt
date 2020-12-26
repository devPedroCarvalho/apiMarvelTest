package test.test.apimarveltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import test.test.apimarveltest.databinding.ActivityMainBinding
import test.test.apimarveltest.databinding.FragmentCharacterListBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    fun showProgressBar(){
        binding.mainProgressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar(){
        binding.mainProgressBar.visibility = View.INVISIBLE

    }
}
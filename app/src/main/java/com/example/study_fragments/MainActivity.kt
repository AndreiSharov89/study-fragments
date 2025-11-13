package com.example.study_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.example.study_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        /*        if (savedInstanceState == null) {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        add<CitiesFragment>(binding.fragmentContainerView.id)
                    }
                }*/

        ViewCompat.setOnApplyWindowInsetsListener(binding.fragmentContainerView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //setOnClickListeners()

    }
    private fun setOnClickListeners() {
        binding.replaceCountryFragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerView.id, CountriesFragment())
                setReorderingAllowed(true)
            }

        }
        binding.replaceBackStackCountryFragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.fragmentContainerView.id, CountriesFragment())
                addToBackStack("my_backstack")
                setReorderingAllowed(true)
            }
        }
    }
}

package com.example.customprogressbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customprogressbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var isStopped = true
    var goalProgress = 0
    var expectedGoal = 50
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.goalProgressBar.apply {
            setProgress(100, false)
            setGoal(50)
        }

        binding.restartBtn.setOnClickListener {
            goalProgress = 0
            if (isStopped) {
                isStopped = false
                expectedGoal = (0..100).random()
                binding.goalProgressBar.setGoal(expectedGoal)
                while (goalProgress < 100) {
                    goalProgress++
                    binding.goalProgressBar.setProgress(goalProgress)
                }
                isStopped = true
            }
        }
    }
}

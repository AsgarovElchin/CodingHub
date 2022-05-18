package com.elchinasgarov.codinghub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.navigation_graph)

        if (auth.currentUser != null) {
            graph.setStartDestination(R.id.bottomNavigationFragment2)
        } else {
            graph.setStartDestination(R.id.loginOrSignUpFragment)
        }

        val navController = navHostFragment.navController
        navController.setGraph(graph, intent.extras)

    }
}
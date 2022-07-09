package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.utils.UserInformation
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
            UserInformation.getUserInfo(auth.currentUser?.email)
            Log.d("kkk","${auth.currentUser?.email}")
            graph.setStartDestination(R.id.mainFragment)
        } else {
            graph.setStartDestination(R.id.loginOrSignUpFragment)
        }

        val navController = navHostFragment.navController
        navController.setGraph(graph, intent.extras)

    }
}
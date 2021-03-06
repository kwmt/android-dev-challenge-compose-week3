/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.BOTTOM_NAVIGATION_ROUTE
import com.example.androiddevchallenge.MainDestinations.LOGIN_ROUTE
import com.example.androiddevchallenge.MainDestinations.WELCOME_ROUTE
import com.example.androiddevchallenge.ui.BottomNavigationScreen
import com.example.androiddevchallenge.ui.login.LoginScreen
import com.example.androiddevchallenge.ui.welcome.WelcomeScreen

object MainDestinations {
    const val WELCOME_ROUTE = "welcome"
    const val LOGIN_ROUTE = "login"
    const val BOTTOM_NAVIGATION_ROUTE = "bottom_navigation"
    const val HOME_ROUTE = "home"
    const val FAVORITES_ROUTE = "favorites"
    const val PROFILE_ROUTE = "profile"
    const val CART_ROUTE = "cart"
}

@Composable
fun NavGraph(startDestination: String = WELCOME_ROUTE) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(navController = navController, startDestination = startDestination) {
        composable(WELCOME_ROUTE) {
            WelcomeScreen(actions.toLoginScreen)
        }
        composable(LOGIN_ROUTE) {
            LoginScreen(actions.toHomeScreen)
        }
        composable(BOTTOM_NAVIGATION_ROUTE) {
            BottomNavigationScreen()
        }
    }
}

class MainActions(navController: NavController) {
    val toLoginScreen: () -> Unit = {
        navController.navigate(LOGIN_ROUTE)
    }
    val toHomeScreen: () -> Unit = {
        navController.navigate(BOTTOM_NAVIGATION_ROUTE)
    }
}

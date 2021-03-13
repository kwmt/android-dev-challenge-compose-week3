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
package com.example.androiddevchallenge.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.CART_ROUTE
import com.example.androiddevchallenge.MainDestinations.FAVORITES_ROUTE
import com.example.androiddevchallenge.MainDestinations.HOME_ROUTE
import com.example.androiddevchallenge.MainDestinations.PROFILE_ROUTE
import com.example.androiddevchallenge.ui.home.HomeScreen

private val bottomNavigationItems = listOf(
    BottomNavigationScreens.Home,
    BottomNavigationScreens.Favorites,
    BottomNavigationScreens.Profile,
    BottomNavigationScreens.Cart
)

@Composable
fun BottomNavigationScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            SpookyAppBottomNavigation(
                navController,
                items = bottomNavigationItems,
            )
        }
    ) {
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = HOME_ROUTE) {
        composable(HOME_ROUTE) {
            HomeScreen()
        }
        composable(FAVORITES_ROUTE) {
            DummyScreen(FAVORITES_ROUTE)
        }
        composable(PROFILE_ROUTE) {
            DummyScreen(PROFILE_ROUTE)
        }
        composable(CART_ROUTE) {
            DummyScreen(CART_ROUTE)
        }
    }
}

@Composable
private fun DummyScreen(text: String) {
    Text(text)
}

@Composable
fun SpookyAppBottomNavigation(
    navController: NavController,
    items: List<BottomNavigationScreens>,
) {
    BottomNavigation {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { screen.icon },
                label = { Text(screen.resourceId) },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}

sealed class BottomNavigationScreens(
    val route: String,
    val resourceId: String,
    val icon: ImageVector
) {
    object Home : BottomNavigationScreens(HOME_ROUTE, "Home", Icons.Filled.Home)
    object Favorites : BottomNavigationScreens(FAVORITES_ROUTE, "Favorites", Icons.Filled.Favorite)
    object Profile : BottomNavigationScreens(PROFILE_ROUTE, "Profile", Icons.Filled.AccountCircle)
    object Cart : BottomNavigationScreens(CART_ROUTE, "Cart", Icons.Filled.ShoppingCart)
}

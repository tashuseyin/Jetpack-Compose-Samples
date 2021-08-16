package com.example.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.profilecardlayout.ui.theme.ProfileCardLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileCardLayoutTheme {
                UserApplication()
            }
        }
    }
}

@Composable
fun UserApplication(userProfiles: List<UserProfile> = userProfileList) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "users_list") {
        composable("users_list") {
            UserListScreen(userProfiles, navController)
        }
        composable(route = "users_details/{userId}", arguments = listOf(navArgument("userId") {
            type = NavType.IntType
        })) { navBackStackEntry ->
            UserProfileDetailScreen(navBackStackEntry.arguments!!.getInt("userId"), navController = navController)
        }
    }
}


@Composable
fun UserListScreen(userProfiles: List<UserProfile>, navController: NavHostController?) {
    Scaffold(topBar = { AppBar(title = "User List", icon = Icons.Default.Home){} }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile) {
                        navController?.navigate("users_details/${userProfile.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun UserProfileDetailScreen(userId: Int, navController: NavHostController?) {
    val userProfile = userProfileList.first { userProfile ->
        userId == userProfile.id
    }
    Scaffold(topBar = { AppBar(title = "User Profile Detail", icon = Icons.Default.ArrowBack){
        navController?.navigateUp()
    } }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(
                    pictureUrl = userProfile.pictureUrl,
                    onlineStatus = userProfile.status,
                    240.dp
                )
                ProfileContent(
                    userName = userProfile.name,
                    onlineStatus = userProfile.status,
                    alignment = Alignment.CenterHorizontally
                )
            }
        }
    }
}

@Composable
fun ProfileCard(userProfile: UserProfile, clickAction: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .clickable { clickAction.invoke() },
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.pictureUrl, userProfile.status, 72.dp)
            ProfileContent(userProfile.name, userProfile.status, Alignment.Start)
        }
    }
}

@Composable
fun ProfilePicture(pictureUrl: String, onlineStatus: Boolean, imageSize: Dp) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = 2.dp,
            color = if (onlineStatus)
                Color.Green
            else
                Color.Red
        ),
        modifier = Modifier
            .padding(16.dp)
            .size(imageSize),
        elevation = 4.dp
    ) {

        Image(
            painter = rememberImagePainter(
                data = pictureUrl,
                builder = { transformations(CircleCropTransformation()) },
            ),
            contentDescription = "image"
        )
    }
}


@Composable
fun ProfileContent(userName: String, onlineStatus: Boolean, alignment: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = alignment
    ) {
        Text(
            text = userName,
            style = TextStyle(
                color = Color.Black,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        )

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = if (onlineStatus)
                    "Active Now"
                else
                    "Offline",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif,
                )
            )
        }
    }
}


@Composable
fun AppBar(title: String, icon: ImageVector, iconClickAction: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            Icon(
                icon,
                contentDescription = "home",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable { iconClickAction.invoke() }
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardLayoutTheme {
        UserListScreen(userProfiles = userProfileList, null)
    }
}

@Preview(showBackground = true)
@Composable
fun UserDefaultPreview() {
    ProfileCardLayoutTheme {
        UserProfileDetailScreen(userId = 0, null)
    }
}
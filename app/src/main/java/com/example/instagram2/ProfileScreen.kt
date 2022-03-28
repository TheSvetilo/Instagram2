package com.example.instagram2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(
        Modifier
            .fillMaxSize()
    ) {
        TopBar("vladnesalad_official")

        ProfileSection()
        Spacer(modifier = Modifier.height(12.dp))

        ProfileDescription(
            "Android Developer",
            "Red Hat is the only open source company for SAP HANA " +
                    "that can show a clear path from the OS via automation to containerization.\n" +
                    "Don't miss out on preparing for the future" +
                    "Red Hat is the only open source company for SAP HANA " +
                    "that can show a clear path from the OS via automation to containerization. ",
            "https://red.ht/3kHI7Xg",
            mutableListOf("dypak", "neDypak"),
            3
        )
        Spacer(modifier = Modifier.height(12.dp))

        ButtonSection()
        Spacer(modifier = Modifier.height(12.dp))

        HighlightSection(
            Modifier, listOf(
                ImageWithText(
                    painterResource(id = R.drawable.me),
                    text = "It's me!"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.me),
                    text = "My Work"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.me),
                    text = "My Places"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.me),
                    text = "My Wife"
                ),
                ImageWithText(
                    painterResource(id = R.drawable.me),
                    text = "My Rules"
                )
            )
        )
        Spacer(modifier = Modifier.height(12.dp))

        PostTabView(
            imagesWithTexts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_bell),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_dotmenu),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_bell),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_dotmenu),
                    text = "Profile"
                )
            )
        ) {
            selectedTabIndex = it
        }
        when(selectedTabIndex) {
            0 -> PostSection(posts = listOf(
                painterResource(id = R.drawable.me),
                painterResource(id = R.drawable.me),
                painterResource(id = R.drawable.me),
                painterResource(id = R.drawable.me),
                painterResource(id = R.drawable.me),
                painterResource(id = R.drawable.me),
                painterResource(id = R.drawable.me),
            ))
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Bell",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {

        Row( // avatar and statistics
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundImage(image = painterResource(id = R.drawable.me))
            Spacer(modifier = Modifier.width(20.dp))
            StatSection()
        }

        Row( // profile description

        ) {

        }
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier,
    color: Color = Color.Red
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f)
            .border(
                width = 1.dp,
                color = color,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
    ) {
        ProfileStat(numberText = "601", description = "Posts")
        ProfileStat(numberText = "99.8K", description = "Followers")
        ProfileStat(numberText = "72", description = "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(200.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val minHeight = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
    ) {
        ActionButton(
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight),
            "Following",
            Icons.Default.ArrowDropDown
        )
        ActionButton(
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight),
            "Message"
        )
        ActionButton(
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(minHeight),
            "Email"
        )
        ActionButton(
            modifier = Modifier
                .defaultMinSize(minWidth = minHeight)
                .height(minHeight),
            "",
            Icons.Default.ArrowDropDown
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (!text.isNullOrEmpty()) {
            Text(
                text = text,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highLights: List<ImageWithText>
) {
    LazyRow(modifier = modifier.padding(start = 20.dp)) {
        items(highLights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 16.dp)
            ) {
                RoundImage(
                    image = highLights[it].image,
                    modifier = Modifier.size(70.dp),
                    color = Color.LightGray
                )
                Text(
                    text = highLights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imagesWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imagesWithTexts.forEachIndexed { index, item ->
            Tab(
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}
package com.example.quizsandbox3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizsandbox3.data.Calon
import com.example.quizsandbox3.data.calons
import com.example.quizsandbox3.ui.theme.Quizsandbox3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quizsandbox3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                    ) {
                    PasApp()
                }
            }
        }
    }
}

@Composable
fun PasApp() {
    Scaffold(
        topBar = {
            PasTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(calons) {
                CalonItem(
                    calon = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(top = 0.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(30.dp)
                )

                Text(
                    text = "Home",
                    color = Color.Gray,
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = colorResource(R.color.biru),
                    modifier = Modifier
                        .size(30.dp)
                )

                Text(
                    text = "Pencarian",
                    color = colorResource(R.color.biru),
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 30.dp, end = 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(30.dp)
                )

                Text(
                    text = "Profil",
                    color = Color.Gray,
                )
            }

        }
    }
}
@Composable
fun CalonItem(
    calon: Calon,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                CalonInfo(calon.nama, calon.umur, calon.alamat)
                Spacer(Modifier.weight(1f))
                CalonItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }
            if (expanded) {
                CalonDes(
                    calon.des, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}
@Composable
private fun CalonItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowRight else Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(R.string.expand_button),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Column (modifier = modifier) {
                Row {
                    Text(
                        text = stringResource(R.string.judul),
                        style = MaterialTheme.typography.displayMedium,
                    )
                        Spacer(Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Rounded.List,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = modifier
                        )

                }
                Column(modifier = modifier) {
                    Text(
                        text = stringResource(R.string.isi),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    )
}


@Composable
fun CalonInfo(
    @StringRes calonNama: Int,
    calonUmur: Int,
    calonAlamat: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(calonNama),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                Text(
                    text = stringResource(R.string.umur, calonUmur),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                )
            }
            Column{
                Icon(
                    imageVector = Icons.Rounded.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = modifier
                )
            }
            Column {
                Text(
                    text = stringResource(calonAlamat),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}
@Composable
fun CalonDes(
    @StringRes calonDes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.tentang),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(calonDes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
@Preview
@Composable
fun PasPreview() {
    Quizsandbox3Theme(darkTheme=false) {
        PasApp()
    }
}
@Preview
@Composable
fun PasDarkThemePreview() {
    Quizsandbox3Theme(darkTheme = true) {
        PasApp()
    }
}
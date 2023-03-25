package com.sharipov.movies.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sharipov.movies.MainViewModel
import androidx.compose.ui.platform.LocalContext
import com.sharipov.movies.utils.HtmlText

@Composable
fun DetailsScreen(viewModel: MainViewModel, itemId: String) {

    val context = LocalContext.current
    val currentItem = viewModel.allMovies
        .observeAsState(listOf()).value
        .firstOrNull {it.id == itemId.toInt()}

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = rememberImagePainter(currentItem?.image?.medium),
                contentDescription = null,
                modifier = Modifier
                    .size(356.dp)
                    .padding(top = 16.dp))

            Text(
                text = currentItem?.name ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
//            HtmlText(
//                html = currentItem?.summary.toString().replace("<p><b>", ""),
//                modifier = Modifier.padding(16.dp)
//            )
            Text(
                text = currentItem?.summary.toString().replace("<p><b>", "")
                    .replace("</p>", "")
                    .replace("<p>", "")
                    .replace("</i>", "")
                    .replace("<i>", "")
                    .replace("<b>", "")
                    .replace("</b>", ""),
                    modifier = Modifier.padding(16.dp)
                )

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(currentItem?.officialSite.toString())
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Official Site")
            }

        }
    }
}
package com.sumyat.newsapp.presentation.commom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sumyat.newsapp.domain.model.Article
import com.sumyat.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleHorizontalItem(article: Article, modifier: Modifier) {
    Row {
        Column(
            modifier = modifier
                .weight(3f)
                .fillMaxSize()
                .padding(top = 8.dp)
        ) {
            article.sourceName?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body2,
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = article.title,
                style = MaterialTheme.typography.subtitle2,
                color = Color.White,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = article.publishedAt,
                style = MaterialTheme.typography.caption,
                color = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            )
        }

        AsyncImage(
            modifier = Modifier
                .weight(1f)
                .height(120.dp)
                .clip(RoundedCornerShape(18.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(article.urlToImage)
                .crossfade(true)
                .build(),
            contentDescription = article.title,
        )
    }
}

@Preview
@Composable
private fun PreviewArticleHorizontalItem() {
    NewsAppTheme {
        ArticleHorizontalItem(
            article = Article(
                806,
                "Horoscope for Monday, September 4, 2023 - Chicago Sun-Times",
                "2023-09-04T05:03:01Z",
                "Suntimes.com",
                "https://chicago.suntimes.com/2023/9/4/23850078/horoscopes-today-monday-september-4-2023",
                "https://cst.brightspotcdn.com/dims4/default/b0d22bc/2147483647/strip/true/crop/870x497+0+67/resize/1461x834!/quality/90/?url=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2Fc4Ov6QK1OQKz-rjJtk24nKM--lU%3D%2F0x0%3A870x630%2F870x630%2Ffilters%3Afocal%28435x315%3A436x316%29%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_asset%2Ffile%2F24880586%2FGeorgia_mug.jpeg"
            ), modifier = Modifier
        )
    }
}
package com.sumyat.newsapp.common

import com.sumyat.newsapp.data.local.article.ArticleEntity
import com.sumyat.newsapp.data.local.bookmark.BookmarkEntity
import com.sumyat.newsapp.data.remote.dto.ArticleDto
import com.sumyat.newsapp.data.remote.dto.SourceDto
import com.sumyat.newsapp.domain.model.Article

object MockData {

    fun createNews(): List<Article> {
        val news = mutableListOf<Article>()
        ('a'..'z').forEachIndexed { index, c ->
            news.add(
                Article(
                    id = index,
                    publishedAt = c.toString(),
                    sourceName = c.toString(),
                    title = c.toString(),
                    url = c.toString(),
                    urlToImage = c.toString()
                )
            )
        }
        return news
    }

    fun createArticle(): Article {
        return Article(
            806,
            publishedAt = "2023-09-04T05:03:01Z",
            sourceName = "Suntimes.com",
            title = "Horoscope for Monday, September 4, 2023 - Chicago Sun-Times",
            url = "https://chicago.suntimes.com/2023/9/4/23850078/horoscopes-today-monday-september-4-2023",
            urlToImage = "https://cst.brightspotcdn.com/dims4/default/b0d22bc/2147483647/strip/true/crop/870x497+0+67/resize/1461x834!/quality/90/?url=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2Fc4Ov6QK1OQKz-rjJtk24nKM--lU%3D%2F0x0%3A870x630%2F870x630%2Ffilters%3Afocal%28435x315%3A436x316%29%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_asset%2Ffile%2F24880586%2FGeorgia_mug.jpeg"
        )
    }


    fun createArticleDto(): ArticleDto {
        return ArticleDto(
            author = "https://www.facebook.com/bbcnews",
            content = "The 2024 Chevrolet Equinox EV.Chevrolet\\r\\n<ul><li>Tons of new and exciting electric vehicles are coming soon. </li><li>Before the end of 2023, we'll see new electric pickups and SUVs.",
            description = "England will be in \\\"new territory\\\" when they face Australia in their maiden World Cup final, says former captain Serena Kersten.",
            publishedAt = "2023-09-04T05:03:01Z",
            source = SourceDto("suntimes", "Suntimes.com"),
            title = "Horoscope for Monday, September 4, 2023 - Chicago Sun-Times",
            url = "https://chicago.suntimes.com/2023/9/4/23850078/horoscopes-today-monday-september-4-2023",
            urlToImage = "https://cst.brightspotcdn.com/dims4/default/b0d22bc/2147483647/strip/true/crop/870x497+0+67/resize/1461x834!/quality/90/?url=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2Fc4Ov6QK1OQKz-rjJtk24nKM--lU%3D%2F0x0%3A870x630%2F870x630%2Ffilters%3Afocal%28435x315%3A436x316%29%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_asset%2Ffile%2F24880586%2FGeorgia_mug.jpeg"

        )
    }

    fun createArticleEntity(): ArticleEntity {
        return ArticleEntity(
            806,
            publishedAt = "2023-09-04T05:03:01Z",
            sourceName = "Suntimes.com",
            title = "Horoscope for Monday, September 4, 2023 - Chicago Sun-Times",
            url = "https://chicago.suntimes.com/2023/9/4/23850078/horoscopes-today-monday-september-4-2023",
            urlToImage = "https://cst.brightspotcdn.com/dims4/default/b0d22bc/2147483647/strip/true/crop/870x497+0+67/resize/1461x834!/quality/90/?url=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2Fc4Ov6QK1OQKz-rjJtk24nKM--lU%3D%2F0x0%3A870x630%2F870x630%2Ffilters%3Afocal%28435x315%3A436x316%29%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_asset%2Ffile%2F24880586%2FGeorgia_mug.jpeg"
        )
    }

    fun createBookEntity(): BookmarkEntity {
        return BookmarkEntity(
            806,
            publishedAt = "2023-09-04T05:03:01Z",
            sourceName = "Suntimes.com",
            title = "Horoscope for Monday, September 4, 2023 - Chicago Sun-Times",
            url = "https://chicago.suntimes.com/2023/9/4/23850078/horoscopes-today-monday-september-4-2023",
            urlToImage = "https://cst.brightspotcdn.com/dims4/default/b0d22bc/2147483647/strip/true/crop/870x497+0+67/resize/1461x834!/quality/90/?url=https%3A%2F%2Fcdn.vox-cdn.com%2Fthumbor%2Fc4Ov6QK1OQKz-rjJtk24nKM--lU%3D%2F0x0%3A870x630%2F870x630%2Ffilters%3Afocal%28435x315%3A436x316%29%2Fcdn.vox-cdn.com%2Fuploads%2Fchorus_asset%2Ffile%2F24880586%2FGeorgia_mug.jpeg"
        )
    }
}
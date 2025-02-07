package com.surya.daynewsapplication.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.surya.daynewsapplication.domain.model.Article
import com.surya.daynewsapplication.presentation.Dimens.MediumPadding1
import com.surya.daynewsapplication.presentation.Dimens.SmallPadding1
import com.surya.daynewsapplication.presentation.common.ArticleList
import com.surya.daynewsapplication.presentation.common.SearchBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
//    val titles by remember {
//        derivedStateOf {
//            if (articles.itemCount > 10) {
//                articles.itemSnapshotList.items
//                    .slice(IntRange(start = 0, endInclusive = 9))
//                    .joinToString(separator = "\t\t\uD83D\uDD34\t") { it.title }
//            } else {
//                ""
//            }
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//            contentDescription = null,
//            modifier = Modifier
//                .width(150.dp)
//                .height(30.dp)
//                .padding(horizontal = MediumPadding1)
//        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        SearchBar(
            modifier = Modifier.padding(horizontal = SmallPadding1),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = navigateToSearch
        )

        Spacer(modifier = Modifier.height(MediumPadding1))
//        Text(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = SmallPadding1, end = SmallPadding1)
//                .basicMarquee(),
//            fontSize = 12.sp,
//            color = MaterialTheme.colorScheme.onSurface,
//            text = titles
//        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        ArticleList(
            modifier = Modifier.padding(horizontal = SmallPadding1),
            articles = articles,
            onClick = navigateToDetails
        )
    }
}
package com.d9.compose.yt.ui.subscriptions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.d9.compose.yt.model.TabFilter
import com.d9.compose.yt.ui.component.DTopAppBar
import com.d9.compose.yt.ui.home.DFilterBar
import com.d9.compose.yt.ui.home.ListVideoHomepage
import com.d9.compose.yt.util.DummyData

@Composable
fun SubscriptionsScreen(
    padding: PaddingValues,
    onSearchClick: () -> Unit,
    onCastClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onFilterClick : (TabFilter) -> Unit = {}
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.navigationBarsPadding()
    ) {
        item("header") {
            DTopAppBar(
                modifier = Modifier
                    .padding(top = padding.calculateTopPadding())
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                onSearchClick = onSearchClick,
                onCastClick = onCastClick,
                onNotificationClick = onNotificationClick,
            )
        }

        item("list_subscriptions") {
            ListSubscriptions(
                listItems = DummyData.listSubscriptions,
                onSubscriptionClick = {

                }
            )
        }

        item("filter_bar") {
            DFilterBar(
                listItems = DummyData.subscriptionsFilter,
                onFilterClick = {
                    onFilterClick(it)
                }
            )
        }

        item("list_video") {
            ListVideoHomepage()
        }

        item {
            Spacer(modifier = Modifier.height(45.dp))
        }
    }
}

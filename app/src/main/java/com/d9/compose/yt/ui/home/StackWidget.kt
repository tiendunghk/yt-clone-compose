package com.d9.compose.yt.ui.home

import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.Coil
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.d9.compose.yt.ui.theme.YoutubeIcons
import com.d9.compose.yt.ui.theme.basicWhite


@Composable
fun StackWidget(url: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        ImageWidget(url = url)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Danh sách kết hợp - ABC của DEF | Official MV",
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "Soobin Hoàng Sơn và nhiều nghệ sĩ khác",
                    style = MaterialTheme.typography.bodySmall
                        .merge(color = Color.Gray)
                )
            }
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }
    }
}


@Composable
fun CroppedImageWithCanvas(
    modifier: Modifier = Modifier,
    url: String,
    height: Dp,
    cornerRadius: Dp,
    fullCorner: Boolean = false,
    elevation: Float = 1f
) {
    val context = LocalContext.current
    var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(url) {
        val result = Coil.imageLoader(context).execute(
            ImageRequest.Builder(context)
                .data(url)
                .build()
        )
        val drawable = (result.drawable as? BitmapDrawable)?.bitmap
        imageBitmap = drawable?.asImageBitmap()
    }



    imageBitmap?.let { bitmap ->
        Canvas(
            modifier = modifier
                .height(height)
                .zIndex(elevation)
        ) {
            val cropHeightPx = height.toPx().toInt()
            val cornerRadiusPx = cornerRadius.toPx()

            val path = Path().apply {
                addRoundRect(
                    RoundRect(
                        rect = Rect(0f, 0f, size.width, size.height),
                        topLeft = CornerRadius(cornerRadiusPx, cornerRadiusPx),
                        topRight = CornerRadius(cornerRadiusPx, cornerRadiusPx),
                        bottomLeft = CornerRadius(
                            if (fullCorner) cornerRadiusPx else 0f,
                            if (fullCorner) cornerRadiusPx else 0f
                        ),
                        bottomRight = CornerRadius(
                            if (fullCorner) cornerRadiusPx else 0f,
                            if (fullCorner) cornerRadiusPx else 0f
                        )
                    )
                )
            }

            drawIntoCanvas {
                clipPath(path) {
                    drawImage(
                        image = bitmap,
                        srcOffset = IntOffset(0, 0), // Crop from top
                        srcSize = IntSize(bitmap.width, cropHeightPx),
                        dstSize = IntSize(size.width.toInt(), cropHeightPx)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageWidget(url: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        CroppedImageWithCanvas(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .align(Alignment.TopCenter),
            url = url,
            height = 4.dp,
            cornerRadius = 10.dp
        )

        CroppedImageWithCanvas(
            modifier = Modifier
                .offset(y = 5.dp)
                .fillMaxWidth(0.95f)
                .align(Alignment.TopCenter),
            url = url,
            height = 4.dp,
            cornerRadius = 10.dp,
            elevation = 2f
        )

        AsyncImage(
            url,
            contentDescription = null,
            modifier = Modifier
                .offset(y = 10.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(200.dp)
                .zIndex(3f),
            contentScale = ContentScale.FillBounds

        )

        Row(
            modifier = Modifier
                .offset(x = (-10).dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color(0xff221611).copy(0.89f))
                .padding(horizontal = 10.dp, vertical = 3.dp)
                .align(Alignment.BottomEnd)
                .zIndex(4f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Image(
                painter = painterResource(YoutubeIcons.icLiveStream), contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "Tuyển tập",
                color = basicWhite,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}
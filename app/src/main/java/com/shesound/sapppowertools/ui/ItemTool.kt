package com.shesound.sapppowertools.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shesound.sapppowertools.R
import com.shesound.sapppowertools.domain.model.Tool
import com.shesound.sapppowertools.ui.theme.red
import com.shesound.sapppowertools.ui.theme.white


@Composable
fun ItemTool(
    modifier: Modifier = Modifier,
    tool: Tool,
    onClick: () -> Unit
) {
    val localDensity = LocalDensity.current
    val cellWidthDp = remember { mutableStateOf(0.dp) }
    val cellHeightDp = remember { mutableStateOf(0.dp) }
    Box (
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
    ){
        Image(
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    cellWidthDp.value =
                        with(localDensity) { coordinates.size.width.toDp() }
                    cellHeightDp.value =
                        with(localDensity) { coordinates.size.height.toDp() }
                },
            painter = painterResource(tool.smallImage),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Text(
            modifier = modifier
                .align(alignment = Alignment.BottomStart)
                .padding(start = 20.dp, bottom = 20.dp),
            text = stringResource(tool.name),
            style = TextStyle(
                fontSize = 25.sp,
                //fontFamily = FontFamily(Font(R.font.MTS Sans)),
                fontWeight = FontWeight(600),
                color = white,
            )
        )
        Button(
            modifier = modifier
                .align(alignment = Alignment.BottomEnd)
                .width(cellWidthDp.value/3.2f)
                .height(cellHeightDp.value/4.1f)
                .padding(end = 10.dp, bottom = 10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = red
            ),
            onClick = onClick
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.send),
                contentDescription = "",
                tint = white
            )
        }
    }
}
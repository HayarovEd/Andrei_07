package com.shesound.sapppowertools.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shesound.sapppowertools.R
import com.shesound.sapppowertools.domain.model.Tool
import com.shesound.sapppowertools.domain.utils.tools
import com.shesound.sapppowertools.ui.theme.black
import com.shesound.sapppowertools.ui.theme.red
import com.shesound.sapppowertools.ui.theme.white
import com.shesound.sapppowertools.ui.theme.yellow

@Preview(name = "NEXUS_7", device = Devices.NEXUS_7)
@Preview(name = "NEXUS_7_2013", device = Devices.NEXUS_7_2013)
@Preview(name = "NEXUS_5", device = Devices.NEXUS_5)
@Preview(name = "NEXUS_6", device = Devices.NEXUS_6)
@Preview(name = "NEXUS_5X", device = Devices.NEXUS_5X)
@Preview(name = "NEXUS_6P", device = Devices.NEXUS_6P)
@Preview(name = "PIXEL", device = Devices.PIXEL)
@Preview(name = "PIXEL_XL", device = Devices.PIXEL_XL)
@Preview(name = "PIXEL_2", device = Devices.PIXEL_2)
@Preview(name = "PIXEL_2_XL", device = Devices.PIXEL_2_XL)
@Preview(name = "PIXEL_3", device = Devices.PIXEL_3)
@Preview(name = "PIXEL_3_XL", device = Devices.PIXEL_3_XL)
@Preview(name = "PIXEL_3A", device = Devices.PIXEL_3A)
@Preview(name = "PIXEL_3A_XL", device = Devices.PIXEL_3A_XL)
@Preview(name = "PIXEL_4", device = Devices.PIXEL_4)
@Preview(name = "PIXEL_4_XL", device = Devices.PIXEL_4_XL)
@Composable
fun CurrentToolScreen(
    modifier: Modifier = Modifier,
    tool: Tool = tools[0],
    onClick: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    val localDensity = LocalDensity.current
    val cellHeightDp = remember { mutableStateOf(0.dp) }
    BackHandler {
        onBackClick()
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = black),
    ) {
        Image(
            modifier = modifier
                .fillMaxSize(),
            painter = painterResource(R.drawable.tools_bg),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Column (
            modifier = modifier
                .align(alignment = Alignment.TopCenter)
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 35.dp, bottom = 50.dp)
        ){
            Button(
                modifier = modifier,
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = red
                ),
                contentPadding = PaddingValues(10.dp),
                onClick = onBackClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "",
                    tint = white
                )
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = modifier
                        .align(alignment = Alignment.Center)
                        .fillMaxHeight()
                        .onGloballyPositioned { coordinates ->
                            cellHeightDp.value =
                                with(localDensity) { coordinates.size.height.toDp() }
                        },
                    painter = painterResource(tool.fullImage),
                    contentDescription = "",
                    contentScale = ContentScale.FillHeight
                )
                Text(
                    modifier = modifier
                        .align(alignment = Alignment.TopCenter)
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    text = stringResource(R.string.power_tool_sound),
                    style = TextStyle(
                        fontSize = 22.sp,
                        //fontFamily = FontFamily(Font(R.font.MTS Sans)),
                        fontWeight = FontWeight(600),
                        color = white,
                        textAlign = TextAlign.Center
                    )
                )
                Button(
                    modifier = modifier
                        .align(alignment = Alignment.BottomCenter)
                        .padding(bottom = cellHeightDp.value/7),
                    shape = RoundedCornerShape(100.dp),
                    border = BorderStroke(
                        width = 2.dp,
                        color = yellow
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = red
                    ),
                    contentPadding = PaddingValues(20.dp),
                    onClick = onClick
                ) {
                    Text(
                        modifier = modifier,
                        text = stringResource(R.string.start_stop),
                        style = TextStyle(
                            fontSize = 25.sp,
                            //fontFamily = FontFamily(Font(R.font.MTS Sans)),
                            fontWeight = FontWeight(600),
                            color = white,
                        )
                    )
                }
            }
        }
    }
}
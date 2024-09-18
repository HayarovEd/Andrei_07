package com.shesound.sapppowertools.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shesound.sapppowertools.R
import com.shesound.sapppowertools.domain.model.AppState
import com.shesound.sapppowertools.domain.model.Tool
import com.shesound.sapppowertools.domain.utils.tools
import com.shesound.sapppowertools.ui.state.MainEvent
import com.shesound.sapppowertools.ui.theme.black
import com.shesound.sapppowertools.ui.theme.white

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
fun ToolsScreen(
    modifier: Modifier = Modifier,
    currentTools: List<Tool> = tools,
    onEvent: (MainEvent) -> Unit = {},
) {
    BackHandler { }
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
        Column(
            modifier = modifier
                .align(alignment = Alignment.TopCenter)
                .padding(start = 20.dp, end = 20.dp, top = 35.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = modifier,
                text = stringResource(R.string.power_tool_sound),
                style = TextStyle(
                    fontSize = 25.sp,
                    //fontFamily = FontFamily(Font(R.font.MTS Sans)),
                    fontWeight = FontWeight(600),
                    color = white,
                )
            )
            LazyColumn(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(currentTools) { tool ->
                    ItemTool(
                        tool = tool,
                        onClick = {
                            onEvent(
                                MainEvent.OnChangeAppState(
                                    AppState.CurrentTool(tool)
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}
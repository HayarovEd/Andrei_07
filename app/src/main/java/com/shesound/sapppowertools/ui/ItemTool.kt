package com.shesound.sapppowertools.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shesound.sapppowertools.R
import com.shesound.sapppowertools.domain.model.Tool
import com.shesound.sapppowertools.domain.utils.tools
import com.shesound.sapppowertools.ui.theme.red
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
fun ItemTool(
    modifier: Modifier = Modifier,
    tool: Tool = tools[0],
    onClick: () -> Unit = {}
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
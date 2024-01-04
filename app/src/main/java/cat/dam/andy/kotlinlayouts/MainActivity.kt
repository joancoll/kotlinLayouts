package cat.dam.andy.kotlinlayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //ShapeExamples()
            //ShapeChangingSurface()
            //ShowText()
            //ShowRow()
            //WeightedColumnExample()
            //WeightedRowExample()
            //ShowScrollableColumnAndRowExample()
            //ShowLazyTable()
            //ShowLazyGrid()
            //SimpleBoxes()
            //ShowBoxWithConstraintsExample()
            //ShowConstraintLayout()
            //ShowDynamicConstraintLayout()
            //ShowGuidelineExample()
            //ShowBarrierExample()
            //ShowChainExample()
            //ShowCombinedFlowExample()
            //ShowFlowExample()
            //ShowFlowGridView()
            //ScaffoldDemo()
            ScaffoldNavDrawer()
        }
    }
}

@Composable
fun ShapeExamples() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ShapeWithText(
            shape = RectangleShape, color = Color.Red, text = "RectangleShape"
        )

        ShapeWithText(
            shape = RoundedCornerShape(16.dp), color = Color.DarkGray, text = "RoundedCornerShape"
        )

        ShapeWithText(
            shape = CutCornerShape(16.dp), color = Color.Magenta, text = "CutCornerShape"
        )

        ShapeWithText(
            shape = CircleShape, color = Color.Blue, text = "CircleShape"
        )
    }
}

@Composable
fun ShapeChangingSurface() {
    var isRectangle by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.primary) // Utilitzar el color del tema
            .border(
                5.dp, Color.Black, if (isRectangle) RectangleShape else CircleShape
            ) // Canviar la forma dinàmicament
            .clickable {
                // Canvia la forma quan es fa clic
                isRectangle = !isRectangle
            },
        //Color i forma controlat per variable estat isRectangle
        color = if (isRectangle) Color.Cyan else Color.Red,
        shape = if (isRectangle) RoundedCornerShape(40.dp) else CircleShape,
    ) {
        Text(
            text = if (isRectangle) "Surface" else "Surface clicked", // Canviar el text en funció de l'estat
            color = if (isRectangle) Color.Black else Color.White, // Canviar color del text en funció de l'estat
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .background(Color.Transparent)
                .wrapContentSize()
        )
    }
}


@Composable
fun ShapeWithText(
    shape: Shape, color: Color, text: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { /* Handle click if needed */ }, shape = shape, color = color
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun ShowText() {
    Column {
        Text("Hello World")
        Text(stringResource(R.string.hello_world))
        Text("Hello World", color = Color.Blue)
        Text("Hello World", fontSize = 30.sp)
        Text("Hello World", fontStyle = FontStyle.Italic)
        Text("Hello World", fontWeight = FontWeight.Bold)
        Text(
            "Hello World", textAlign = TextAlign.Center, modifier = Modifier.width(150.dp)
        )
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("W")
            }
            append("orld")
        })
        TextShadow()
        TextFont()
        SelectionContainer {
            Text("This text is selectable")
        }
        Text("hello ".repeat(50), maxLines = 2)
    }
}

@Composable
fun TextShadow() {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = "Hello world!", style = TextStyle(
            fontSize = 24.sp, shadow = Shadow(
                color = Color.Blue, offset = offset, blurRadius = 3f
            )
        )
    )
}

@Composable
fun TextFont() {
    val myAppFontFamily = FontFamily(
        Font(R.font.silkscreen_bold, FontWeight.Bold),
        Font(R.font.silkscreen_regular, FontWeight.Normal),
    )
    Text("My font Bold", fontFamily = myAppFontFamily, fontWeight = FontWeight.Bold)
    Text("My font Normal", fontFamily = myAppFontFamily, fontWeight = FontWeight.Normal)
}

@Composable
fun ShowColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        //verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Text 1",
            modifier = Modifier.background(Color.Gray),
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            text = "Text 2",
            modifier = Modifier.background(Color.Blue),
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            text = "Text 3",
            modifier = Modifier.background(Color.Green),
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}

@Composable
fun ShowRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Text 1",
            modifier = Modifier.background(Color.Gray),
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            text = "Text 2",
            modifier = Modifier.background(Color.Blue),
            fontSize = 24.sp,
            color = Color.White
        )
        Text(
            text = "Text 3",
            modifier = Modifier.background(Color.Green),
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}

@Composable
fun WeightedColumnExample() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Primer element amb pes 1
        Text(
            text = "Element 1",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Gray)
                .weight(1f),
            fontSize = 24.sp,
            color = Color.White
        )

        // Segon element amb pes 2
        Text(
            text = "Element 2",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Blue)
                .weight(2f),
            fontSize = 24.sp,
            color = Color.White
        )

        // Tercer element amb pes 3
        Text(
            text = "Element 3",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Green)
                .weight(3f),
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}

@Composable
fun WeightedRowExample() {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Primer element amb pes 1
        Text(
            text = "Element 1",
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .background(Color.Gray)
                .weight(1f),
            fontSize = 24.sp,
            color = Color.White
        )

        // Segon element amb pes 2
        Text(
            text = "Element 2",
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .background(Color.Blue)
                .weight(2f),
            fontSize = 24.sp,
            color = Color.White
        )

        // Tercer element amb pes 3
        Text(
            text = "Element 3",
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .background(Color.Green)
                .weight(3f),
            fontSize = 24.sp,
            color = Color.Black
        )
    }
}

@Composable
fun ShowScrollableColumnAndRowExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Scrollable Column Example",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )

        // Contingut de la Column amb desplaçament vertical
        repeat(20) {
            Text(text = "Item $it", modifier = Modifier.padding(4.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Scrollable Row Example",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )

        // Contingut de la Row amb desplaçament horitzontal
        Row(
            modifier = Modifier
                .background(Color.Gray)
                .horizontalScroll(rememberScrollState())
        ) {
            repeat(20) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.White)
                        .padding(16.dp)
                )
            }
        }
    }
}

data class Invoice(val invoice: String, val date: String, val status: String, val amount: String)

@Composable
fun ShowLazyTable() {
    val invoiceList = generateInvoiceList(50)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(8.dp)
        ) {
            Text(
                text = "Invoice",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Date",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Status",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Amount", color = Color.White, fontWeight = FontWeight.Bold
            )
        }

        // Invoice Rows
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(invoiceList) { invoice ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = invoice.invoice,
                        modifier = Modifier
                            .width(100.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = invoice.date, modifier = Modifier
                            .width(100.dp)
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = invoice.status, modifier = Modifier
                            .width(100.dp)
                            .padding(end = 8.dp)
                    )
                    Text(text = invoice.amount)
                }
            }
        }
    }
}

fun generateInvoiceList(size: Int): List<Invoice> {
    return List(size) { index ->
        Invoice(
            "510${index + 1}",
            "15/04/2023",
            if (index % 2 == 0) "Unpaid" else "Paid",
            amount = "${(index + 1) * 100}€"
        )
    }
}

@Composable
fun ShowLazyGrid() {
    val invoiceList = generateInvoiceList(50)
    LazyHorizontalGrid(
        rows = GridCells.Fixed(7),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(invoiceList) { invoice ->
            InvoiceItem(invoice)
        }
    }
}

@Composable
fun InvoiceItem(invoice: Invoice) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
    ) {
        Text(
            text = invoice.invoice, modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
        Text(
            text = invoice.amount, modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SimpleBoxes() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .zIndex(3f)
                .background(color = Color.Green)
                .width(200.dp)
                .height(200.dp)
        )
        Box(
            modifier = Modifier
                .zIndex(1f)
                // Primer clip i després background i border
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color.Cyan)
                .border(
                    width = 2.dp, color = Color.Black, shape = RoundedCornerShape(20.dp)
                )
                .width(150.dp)
                .height(150.dp)
                .align(Alignment.CenterEnd)
        )
        Box(
            modifier = Modifier
                .zIndex(2f)
                .background(color = Color.Red)
                .width(150.dp)
                .height(350.dp)
        )
        Box(
            modifier = Modifier
                .zIndex(1f)
                .background(color = Color.Magenta)
                .width(200.dp)
                .height(100.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        Box(
            modifier = Modifier
                .zIndex(3f)
                .background(color = Color.Green)
                .width(200.dp)
                .height(200.dp)
        )
        Box(
            modifier = Modifier
                .zIndex(1f)
                .background(color = Color.Cyan)
                .width(300.dp)
                .height(300.dp)
        )
        Box(
            modifier = Modifier
                .zIndex(2f)
                .background(color = Color.Red)
                .width(150.dp)
                .height(350.dp)
        )
        ShowBoxWithBorderGradient()
        Box(
            modifier = Modifier
                .zIndex(1f)
                .background(color = Color.Magenta)
                .width(200.dp)
                .height(100.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun ShowBoxWithBorderGradient() {
    Box(
        Modifier
            .fillMaxSize()
            .zIndex(4f)
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .border(
                    width = 10.dp, shape = CircleShape, brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Blue,
                            Color.Cyan,
                            Color.Green,
                            Color.Magenta,
                            Color.Red,
                            Color.Yellow
                        ),
                    )
                )
                .align(Alignment.CenterEnd)
                .clip(shape = CircleShape)
                .background(color = Color.Yellow)
                .width(200.dp)
                .height(300.dp)
                .clickable(onClick = {
                    println("I clicked")
                })
                .padding(all = 30.dp)
        ) {
            Text(text = "Testing Boxs")
        }
    }
}

@Composable
fun ShowBoxWithConstraintsExample() {
    BoxWithConstraints {
        val boxWithConstraintsScope = this
        // Obté les dimensions i constraints
        val minHeight = boxWithConstraintsScope.minHeight
        val maxHeight = boxWithConstraintsScope.maxHeight
        val minWidth = boxWithConstraintsScope.minWidth
        val maxWidth = boxWithConstraintsScope.maxWidth
        val constraints = boxWithConstraintsScope.constraints

        Column {
            // Informació sobre les dimensions
            Text("minHeight: $minHeight")
            Text("maxHeight: $maxHeight")
            Text("minWidth: $minWidth")
            Text("maxWidth: $maxWidth")

            // Informació sobre les constraints
            Text("Constraints: $constraints")

            Spacer(modifier = Modifier.height(16.dp))
            if (boxWithConstraintsScope.maxWidth >= 500.dp) {
                Text(
                    "Això només és visible quan la maxWidth és >= 500.dp",
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .background(color = Color.Green)
                        .padding(16.dp)
                )
            } else {
                Text(
                    "Això és visible quan la maxWidth és < 500.dp",
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier
                        .background(color = Color.Red)
                        .padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun ShowConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (myText, aboveText, belowText) = createRefs()

        Text(text = "El meu text",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(myText) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
                .background(color = Color.Yellow)
                .wrapContentWidth(),
            color = Color.Black)
        // ... Altres textos referenciats a myText
        Text(text = "A dalt del text", modifier = Modifier
            .constrainAs(aboveText) {
                bottom.linkTo(myText.top)
                start.linkTo(myText.end)
            }
            .layoutId("aboveText")
            .background(color = MaterialTheme.colorScheme.primary)
            .wrapContentWidth(), color = MaterialTheme.colorScheme.onPrimary)

        Text(text = "A sota del text amb un marge de 8dp",
            modifier = Modifier
                .constrainAs(belowText) {
                    top.linkTo(myText.bottom, margin = 8.dp)
                    start.linkTo(myText.end)
                }
                .layoutId("belowText")
                .background(color = MaterialTheme.colorScheme.primary)
                .wrapContentWidth(),
            color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Composable
fun ShowDynamicConstraintLayout() {
    BoxWithConstraints {
        val constraints = if (maxWidth > maxHeight) {
            // Landscape constraints
            dynamicConstraints(margin = 50.dp)
        } else {
            // Portrait constraints
            dynamicConstraints(margin = 16.dp)
        }

        ConstraintLayout(constraints, modifier = Modifier.padding(16.dp)) {
            Text(
                text = "El meu text",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .layoutId("myText")
                    .background(color = Color.Yellow)
                    .wrapContentWidth(),
                color = Color.Black
            )
            // ... Altres textos referenciats a myText
            Text(
                "A dalt del text",
                modifier = Modifier
                    .layoutId("aboveText")
                    .background(color = MaterialTheme.colorScheme.primary)
                    .wrapContentWidth(),
                color = MaterialTheme.colorScheme.onPrimary
            )

            Text(
                "A sota del text amb un marge de 8dp",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .layoutId("belowText")
                    .background(color = MaterialTheme.colorScheme.primary)
                    .wrapContentWidth(),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

private fun dynamicConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val myText = createRefFor("myText")
        val aboveText = createRefFor("aboveText")
        val belowText = createRefFor("belowText")

        constrain(myText) {
            top.linkTo(parent.top, margin = margin * 2)
            start.linkTo(parent.start, margin = 16.dp)
        }

        constrain(aboveText) {
            bottom.linkTo(myText.top, margin = margin)
            start.linkTo(myText.end)
        }

        constrain(belowText) {
            top.linkTo(myText.bottom, margin = margin)
            start.linkTo(myText.end)
        }
    }
}

@Composable
fun ShowGuidelineExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val (textTop, textBottom, textLeft, textRight) = createRefs()

        val startGuideline = createGuidelineFromStart(0.1f) // 10%
        val endGuideline = createGuidelineFromEnd(0.1f) // 10%
        val topGuideline = createGuidelineFromTop(0.1f) // 10%
        val bottomGuideline = createGuidelineFromBottom(0.1f) // 10%
        val centerGuideline = createGuidelineFromTop(0.5f) // 50%

        Text(text = "Text Top Left", modifier = Modifier.constrainAs(textTop) {
            top.linkTo(topGuideline)
            start.linkTo(startGuideline)
        })

        Text(text = "Text Bottom Right", modifier = Modifier.constrainAs(textBottom) {
            bottom.linkTo(bottomGuideline)
            end.linkTo(endGuideline)
        })

        Text(text = "Text Left", modifier = Modifier.constrainAs(textLeft) {
            bottom.linkTo(centerGuideline)
            start.linkTo(startGuideline)
        })

        Text(text = "Text Right", modifier = Modifier.constrainAs(textRight) {
            bottom.linkTo(centerGuideline)
            end.linkTo(endGuideline)
        })
    }
}

@Composable
fun ShowBarrierExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Define the two centered texts
        val (text1, text2, belowText) = createRefs()
        val centerGuideline = createGuidelineFromStart(0.5f)

        Text(
            text = createContent(10).joinToString("\n"), modifier = Modifier.constrainAs(text1) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(centerGuideline)
            }, style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = createContent(5).joinToString("\n"), modifier = Modifier.constrainAs(text2) {
                top.linkTo(text1.top)
                start.linkTo(centerGuideline)
                end.linkTo(parent.end)
            }, style = MaterialTheme.typography.bodyMedium
        )

        // Define the barrier
        val barrier = createBottomBarrier(text1, text2)

        // Define the text below the barrier
        Text(
            text = "Below Text", modifier = Modifier.constrainAs(belowText) {
                top.linkTo(barrier, margin = 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }, style = MaterialTheme.typography.bodyLarge, color = Color.Gray
        )
    }
}

fun createContent(count: Int): List<String> {
    return (0 until count).map { index ->
        "Text ${index.plus(1)}"
    }
}

@Composable
fun ShowChainExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ChainTextBlock(
            title = "Chain Style: Spread", chainStyle = ChainStyle.Spread
        )

        ChainTextBlock(
            title = "Chain Style: Spread Inside", chainStyle = ChainStyle.SpreadInside
        )

        ChainTextBlock(
            title = "Chain Style: Packed", chainStyle = ChainStyle.Packed
        )
    }
}

@Composable
fun ChainTextBlock(title: String, chainStyle: ChainStyle) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        val (chainTitle, text1, text2, text3) = createRefs()

        // Chain Definition
        createHorizontalChain(text1, text2, text3, chainStyle = chainStyle)

        // Title
        Text(text = title, modifier = Modifier
            .constrainAs(chainTitle) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .padding(bottom = 4.dp), fontWeight = FontWeight.Bold)

        // Text Blocks
        Text(text = "Text 1", modifier = Modifier
            .constrainAs(text1) {
                top.linkTo(chainTitle.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
            .background(Color.Gray)
            .padding(8.dp), color = Color.White)

        Text(text = "Text 2", modifier = Modifier
            .constrainAs(text2) {
                top.linkTo(chainTitle.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            .background(Color.Gray)
            .padding(8.dp), color = Color.White)
        Text(text = "Text 3", modifier = Modifier
            .constrainAs(text3) {
                top.linkTo(chainTitle.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
            .background(Color.Gray)
            .padding(8.dp), color = Color.White)
    }
}

@Composable
fun ShowCombinedFlowExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Primer 50% de l'alçada: FlowColumn
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .align(Alignment.TopStart)
        ) {
            CreateFlowColumn(num = 5)
            Text(
                "FlowColumn Example",
                fontWeight = FontWeight.Bold,
            )
        }
        // Segon 50% de l'alçada: FlowRow
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomStart)
        ) {
            CreateFlowRow(num = 10)
            Text(
                "FlowRow Example",
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CreateFlowColumn(num: Int) {
    FlowColumn(
        modifier = Modifier.padding(1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        repeat(num) { i ->
            val itemModifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.primary)
            Spacer(modifier = itemModifier)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CreateFlowRow(num: Int) {
    FlowRow(
        modifier = Modifier.padding(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        repeat(num) { i ->
            val itemModifier = Modifier
                .padding(1.dp)
                .fillMaxHeight()
                .weight(1f)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.primary)
            Spacer(modifier = itemModifier)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ShowFlowExample() {
    FlowRow(
        Modifier
            .fillMaxWidth(1f)
            .padding(20.dp)
            .wrapContentHeight(align = Alignment.Top),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        maxItemsInEachRow = 5
    ) {
        repeat(20) {
            Box(
                Modifier
                    .align(Alignment.CenterVertically)
                    .width(50.dp)
                    .height(50.dp)
                    .background(Color.Green)
            ) {
                Text(
                    text = it.plus(1).toString(),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(3.dp)
                )
            }
        }
    }
}

@Composable
fun ShowFlowGridView() {
    flowGridView(rows = 8, columns = 10)
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun flowGridView(rows: Int, columns: Int) {
    FlowColumn(
        modifier = Modifier.padding(1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
    ) {
        repeat(rows) {
            val itemModifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(4.dp))

            Box(modifier = itemModifier) {
                FlowRow(
                    modifier = Modifier.padding(1.dp),
                    horizontalArrangement = Arrangement.spacedBy(1.dp),
                ) {
                    repeat(columns) { i ->
                        val itemModifier = Modifier
                            .padding(1.dp)
                            .fillMaxHeight()
                            .weight(1f)
                            .clip(RoundedCornerShape(4.dp))
                            .background(MaterialTheme.colorScheme.primary)
                        Spacer(modifier = itemModifier)
                    }
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
// Per utilitzar el Scaffold cal indicar que és encara en fase experimental
@Composable
fun ScaffoldDemo() {
    // Crea una instància de SnackbarHostState per gestionar les Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    // Crea un CoroutineScope per a utilitzar en la gestió d'events asincrònics com ara SnackBar
    val coroutineScope = rememberCoroutineScope()
    // Obté el context de l'aplicació per utilitzar en els Toast
    val context = LocalContext.current.applicationContext
    // Utilitza el Scaffold per estructurar la UI de la pantalla amb subfuncions
    Scaffold(
        // Color del fons del contenidor principal
        containerColor = Color.Yellow,
        // Color del text del contingut
        contentColor = Color.Black,
        // Contingut de la TopAppBar
        topBar = { TopAppBarContent(context) },
        // Contingut del FloatingActionButton
        floatingActionButton = { FabContent(snackbarHostState, coroutineScope) },
        // Contingut principal de la pantalla amb ajustaments de padding
        content = { innerPadding -> ScaffoldContent(innerPadding, context) },
        // Contingut de la BottomAppBar
        bottomBar = { BottomAppBarContent(context) },
        // SnackbarHost per mostrar Snackbar a la pantalla
        snackbarHost = { SnackbarHostContent(snackbarHostState) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(context: Context) {
    TopAppBar(
        modifier = Modifier.clickable {
            Toast.makeText(context, "TopAppBar clicked", Toast.LENGTH_SHORT).show()
        },
        title = { Text(text = "TopAppBar") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White
        )
    )
}

@Composable
fun BottomAppBarContent(context: Context) {
    BottomAppBar(
        modifier = Modifier.clickable {
                Toast.makeText(context, "BottomAppBar clicked", Toast.LENGTH_SHORT).show()
            }
            .padding(8.dp),
        containerColor = Color.Gray,
        contentColor = Color.White
    ) {
        Text(text = "BottomAppBar")
    }
}

@Composable
fun FabContent(snackbarHostState: SnackbarHostState, coroutineScope: CoroutineScope) {
    FloatingActionButton(
        onClick = {
            coroutineScope.launch {
                snackbarHostState.currentSnackbarData?.dismiss()
                snackbarHostState.showSnackbar(
                    message = "You clicked on FAB. This is a Snackbar",
                    actionLabel = "Dismiss",
                    duration = SnackbarDuration.Short
                )
            }
        },
        containerColor = Color.Magenta,
        contentColor = Color.White,
        shape = CircleShape
    ) { Text("FAB") }
}

@Composable
fun ScaffoldContent(innerPadding: PaddingValues, context: Context) {
    Text(
        text = "Content",
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.Green)
            .clickable {Toast.makeText(context, "Content clicked", Toast.LENGTH_SHORT).show()}
    )
}

@Composable
fun SnackbarHostContent(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { snackbarData ->
            Snackbar(
                snackbarData = snackbarData,
                modifier = Modifier.padding(8.dp),
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                actionColor = MaterialTheme.colorScheme.onTertiaryContainer,
                shape = MaterialTheme.shapes.small,
            )
        }
    )
}


@Composable
fun ScaffoldNavDrawer() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        MyScaffoldLayout()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffoldLayout() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed) // State per al Drawer
    val drawerItemList = prepareNavigationDrawerItems() // Llista d'ítems del Drawer
    val selectedDrawerItem =
        remember { mutableStateOf(drawerItemList[0]) } // ítem seleccionat del Drawer
    val snackbarHostState = remember { SnackbarHostState() } // State per a la Snackbar
    val coroutineScope = rememberCoroutineScope() // Scope per a la Snackbar
    val context = LocalContext.current.applicationContext // Context per a Toast

    // Creem el Drawer de forma que es tanca quan es fa clic en un ítem

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = MaterialTheme.shapes.large,
                drawerTonalElevation = 0.dp,
                drawerContainerColor = MaterialTheme.colorScheme.primaryContainer,
                drawerContentColor = MaterialTheme.colorScheme.onPrimary,
            ) {
                // add drawer content here
                // this is a column scope
                // so, if you add multiple elements, they are placed vertically
                Spacer(Modifier.height(12.dp))
                drawerItemList.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        label = { Text(text = item.label) },
                        selected = (item == selectedDrawerItem.value),
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            Toast.makeText(context, item.label, Toast.LENGTH_SHORT).show()
                            selectedDrawerItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        })
    {
        // Funció que conté el Scaffold
        // Al ser content el darrer paràmetre, es pot utilitzar fora dels parèntesis
        // i així es pot utilitzar el valor de les variables declarades abans
        // (drawerState, drawerItemList, selectedDrawerItem, snackbarHostState, coroutineScope, context)
        Scaffold(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            topBar = {
                MyTopAppBar {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                }
            },
            bottomBar = {
                MyBottomAppBar() { selectedOption ->
                    coroutineScope.launch {
                        // Esborra la Snackbar actual
                        snackbarHostState.currentSnackbarData?.dismiss()
                        // Mostra la Snackbar amb el text de l'opció seleccionada
                        snackbarHostState.showSnackbar(
                            message = "Selected $selectedOption",
                            actionLabel = "Dismiss",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            },
            floatingActionButton = { MyFAB(contextForToast = context) },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState, snackbar = { snackbarData ->
                    Snackbar(
                        snackbarData = snackbarData,
                        modifier = Modifier.padding(16.dp),
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                        actionColor = MaterialTheme.colorScheme.onTertiaryContainer,
                        shape = MaterialTheme.shapes.small,
                    )
                })
            },
        ) { innerPadding ->
            // rest of the app's UI
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.Yellow)

            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(100) {
                        Text(text = "Text $it", modifier = Modifier.padding(vertical = 10.dp))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onIconClick: () -> Unit) {
    TopAppBar(title = { Text(text = "Scaffold Navigation Drawer") }, navigationIcon = {
        IconButton(onClick = {
            onIconClick()
        }) {
            Icon(
                imageVector = Icons.Default.Menu, contentDescription = "Open Navigation Items"
            )
        }
    }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    )
    )
}

@Composable
private fun MyBottomAppBar(onIconClick: (String) -> Unit) {
    BottomAppBar(
        modifier = Modifier.padding(8.dp),
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Spacer(modifier = Modifier.weight(1f)) // Alinea els elements a la dreta
        IconButton(onClick = { onIconClick("Home") }) {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
        }
        IconButton(onClick = { onIconClick("Favourites") }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favourites")
        }
        IconButton(onClick = { onIconClick("Search") }) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
        }
        IconButton(onClick = { onIconClick("More") }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More")
        }
    }
}

@Composable
private fun MyFAB(contextForToast: Context) {
    FloatingActionButton(onClick = {
        Toast.makeText(contextForToast, "FAB clicked", Toast.LENGTH_SHORT).show()
    }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

private fun prepareNavigationDrawerItems(): List<NavigationDrawerData> {
    val drawerItemsList = arrayListOf<NavigationDrawerData>()

    // add items
    drawerItemsList.add(NavigationDrawerData(label = "Home", icon = Icons.Filled.Home))
    drawerItemsList.add(NavigationDrawerData(label = "Profile", icon = Icons.Filled.Person))
    drawerItemsList.add(NavigationDrawerData(label = "Cart", icon = Icons.Filled.ShoppingCart))
    drawerItemsList.add(NavigationDrawerData(label = "Settings", icon = Icons.Filled.Settings))

    return drawerItemsList
}

data class NavigationDrawerData(val label: String, val icon: ImageVector)
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTextInput

@Preview
@Composable
fun DropDownSpecializationProfile() {

    val items = listOf("Не выбрано", "Программист", "Дизайнер", "Аналитик", "Экономист", "Химик")

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(items[0]) }

//    // Состояние для анимации
//    val textColor: Color by animateColorAsState(
//        if (expanded) Color.White else Color.Black,
//        TweenSpec(300), label = ""
//    )
//    val backgroundColor by animateColorAsState(
//        if (expanded) Color.Blue else Color.LightGray,
//        TweenSpec(300), label = ""
//    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = ColorBackgroundTextField, shape = RoundedCornerShape(15.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column (
                modifier = Modifier
                    .padding(bottom = 5.dp),
                verticalArrangement = Arrangement.Top
            ){

                Text(
                    stringResource(id = R.string.text_specialization),
                    style = TextStyle(
                        color = ColorTextHint,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(700)
                    )
                )
                Text (
                    text = selectedOption,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                        fontWeight = FontWeight(700),
                        color = ColorTextInput,
                    )
                )
            }

            Icon(painter = painterResource(id = R.drawable.ic_arrowdown), contentDescription = "image arrow down")
        }
        
        Spacer(modifier = Modifier.padding(top = 6.dp))

        if (expanded) {

            Column (modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ColorBackgroundTextField,
                    shape = RoundedCornerShape(size = 15.dp)
                )){

                items.forEach { item ->
                    Text(
                        text = item,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                            fontWeight = FontWeight(700),
                            color = ColorTextInput,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedOption = item
                                expanded = false
                            }
                            .padding(horizontal = 16.dp, vertical = 14.dp)
                    )
                }

            }


        }
    }
}
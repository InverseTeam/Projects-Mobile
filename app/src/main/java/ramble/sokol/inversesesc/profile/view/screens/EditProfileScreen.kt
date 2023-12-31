package ramble.sokol.inversesesc.profile.view.screens

import DropDownSpecializationProfile
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dokar.chiptextfield.Chip
import com.dokar.chiptextfield.m3.ChipTextField
import com.dokar.chiptextfield.m3.OutlinedChipTextField
import com.dokar.chiptextfield.rememberChipTextFieldState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForEntry
import ramble.sokol.inversesesc.destinations.BottomMenuScreenDestination
import ramble.sokol.inversesesc.destinations.ProfileScreenDestination
import ramble.sokol.inversesesc.profile.view.components.ItemMoreInformation
import ramble.sokol.inversesesc.profile.view.components.MoreInformationBlock
import ramble.sokol.inversesesc.ui.theme.ColorCheckBox
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTitle
import ramble.sokol.sberafisha.authentication_and_splash.view.components.InputTextEntry
import ramble.sokol.sberafisha.authentication_and_splash.view.components.MultiLineInputTextEntry

private lateinit var name: MutableState<String>
private lateinit var surname: MutableState<String>
private lateinit var classText: MutableState<String>
private lateinit var email: MutableState<String>
private lateinit var telegram: MutableState<String>
private lateinit var checked: MutableState<Boolean>
private lateinit var aboutMe: MutableState<String>
private lateinit var phone: MutableState<String>

@Composable
@Destination
fun EditProfileScreen(
    navigator: DestinationsNavigator
){

    var clickItemOne by remember {
        mutableStateOf(false)
    }

    val iconItemOne: Int =
        if (clickItemOne)
            R.drawable.icon_hide_content
        else
            R.drawable.icon_plus

    var clickItemTwo by remember {
        mutableStateOf(false)
    }

    val iconItemTwo: Int =
        if (clickItemTwo)
            R.drawable.icon_hide_content
        else
            R.drawable.icon_plus

    var clickItemThree by remember {
        mutableStateOf(false)
    }

    val iconItemThree: Int =
        if (clickItemThree)
            R.drawable.icon_hide_content
        else
            R.drawable.icon_plus

    name = remember {
        mutableStateOf("")
    }

    surname = remember {
        mutableStateOf("")
    }

    classText = remember {
        mutableStateOf("")
    }

    email = remember {
        mutableStateOf("")
    }

    telegram = remember {
        mutableStateOf("")
    }

    checked = remember {
        mutableStateOf(false)
    }

    aboutMe = remember {
        mutableStateOf("")
    }

    phone = remember {
        mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 33.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.padding(top = 17.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
            ){

            Icon(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable {
                        navigator.popBackStack()
                        navigator.navigate(BottomMenuScreenDestination)
                    },
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = "ic_arrow_left"
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.text_edit),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                    fontWeight = FontWeight(700),
                    color = ColorTitle,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.24.sp,
                ),
                textAlign = TextAlign.Center
            )

        }


        Spacer(modifier = Modifier.padding(top = 32.dp))

        Box(
            modifier = Modifier.fillMaxWidth(0.45f),
            contentAlignment = Alignment.BottomEnd
        ){

            Image(
                painter = painterResource(id = R.drawable.image_add_photo),
                contentDescription = "image add photo"
            )

            Box(
                modifier = Modifier.fillMaxSize(0.4f),
                contentAlignment = Alignment.BottomEnd
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_add_photo),
                    contentDescription = "image add photo"
                )
            }

        }

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_general_information),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                fontWeight = FontWeight(500),
                color = ColorTitle,
                letterSpacing = 0.18.sp,
            ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        InputTextEntry(
            text = name.value,
            onValueChange = {
                name.value = it
            },
            idText = R.string.text_name,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {

                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        InputTextEntry(
            text = surname.value,
            onValueChange = {
                surname.value = it
            },
            idText = R.string.text_surname,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {

                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        InputTextEntry(
            text = classText.value,
            onValueChange = {
                classText.value = it
            },
            idText = R.string.text_class,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {

                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        ButtonForEntry(text = stringResource(id = R.string.text_save)) {

        }

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_contacts),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                fontWeight = FontWeight(500),
                color = ColorTitle,
                letterSpacing = 0.18.sp,
            ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        InputTextEntry(
            text = phone.value,
            onValueChange = {
                phone.value = it
            },
            idText = R.string.text_phone_number,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {

                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        InputTextEntry(
            text = email.value,
            onValueChange = {
                email.value = it
            },
            idText = R.string.text_email,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {

                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        InputTextEntry(
            text = telegram.value,
            idText = R.string.text_telegram,
            onValueChange = {
                telegram.value = it
            },
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {

                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 17.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){

            Checkbox(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                checked = checked.value,
                onCheckedChange = { checked_ ->
                    checked.value = checked_
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = ColorCheckBox
                )
            )

            Spacer(modifier = Modifier.padding(start = 8.dp))

            Text(
                text = stringResource(id = R.string.text_view_data_checkbox),
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                    fontWeight = FontWeight(400),
                    color = ColorTextHint,
                )
            )

        }

        Spacer(modifier = Modifier.padding(top = 24.dp))

        ButtonForEntry(text = stringResource(id = R.string.text_save)) {

        }

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_about_me),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                fontWeight = FontWeight(500),
                color = ColorTitle,
                letterSpacing = 0.18.sp,
            ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        DropDownSpecializationProfile()

        Spacer(modifier = Modifier.padding(top = 8.dp))

        val state = rememberChipTextFieldState<Chip>()
        ChipTextField(
            state = state,
            onSubmit = ::Chip,
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        MultiLineInputTextEntry(
            text = aboutMe.value,
            idText = R.string.text_about_me,
            onValueChange = {
                aboutMe.value = it
            },
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {

                            }
                        }
                    }
                })

        Spacer(modifier = Modifier.padding(top = 8.dp))

        ButtonForEntry(text = stringResource(id = R.string.text_save)) {

        }

        Spacer(modifier = Modifier.padding(top = 32.dp))

    }

}
package ramble.sokol.inversesesc.main.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ramcosta.composedestinations.DestinationsNavHost
import ramble.sokol.inversesesc.NavGraphs


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            DestinationsNavHost(navGraph = NavGraphs.root)
        }
    }
}
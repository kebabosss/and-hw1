package cz.fit.cvut.biand.homework1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cz.fit.cvut.biand.homework1.ui.theme.Homework1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Homework1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text (
                        text = "Hello world!",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
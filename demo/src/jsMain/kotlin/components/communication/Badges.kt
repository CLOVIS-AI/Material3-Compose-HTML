package opensavvy.material3.demo.components.communication

import androidx.compose.runtime.Composable
import opensavvy.material3.demo.utils.Section
import opensavvy.material3.demo.utils.named
import opensavvy.material3.demo.utils.rememberParameters
import opensavvy.material3.html.communication.badges.Badge
import org.jetbrains.compose.web.dom.B
import org.jetbrains.compose.web.dom.Text

@Composable
fun Badges() = Section("Badges") {
	val parameters = rememberParameters()

	Badge(parameters.named("Count (should be a number)", "").toIntOrNull()) {
		B {
			Text("This text has a badge.")
		}
	}

	parameters.draw()
}

package opensavvy.material3.demo.components.containment

import androidx.compose.runtime.Composable
import opensavvy.material3.html.containment.dividers.Divider
import opensavvy.material3.html.containment.dividers.InsetDivider
import opensavvy.material3.demo.utils.Section
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Dividers() = Section("Dividers") {
	P { Text("Full-width dividers are used to separate sections of unrelated contents:") }
	Divider()

	P { Text("Inset dividers are used to separate related content within a section:") }
	InsetDivider()
}

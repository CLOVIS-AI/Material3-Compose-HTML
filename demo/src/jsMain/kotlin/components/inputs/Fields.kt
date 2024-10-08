package opensavvy.material3.demo.components.inputs

import androidx.compose.runtime.*
import opensavvy.material3.html.inputs.FieldStyle
import opensavvy.material3.html.inputs.TextField
import opensavvy.material3.demo.utils.Section
import opensavvy.material3.demo.utils.named
import opensavvy.material3.demo.utils.rememberParameters
import org.jetbrains.compose.web.dom.Text

@Composable
fun Fields() = Section("Fields") {
	val parameters = rememberParameters()

	val leadingIcon: @Composable () -> Unit = { Text("+") }
	val trailingIcon: @Composable () -> Unit = { Text("€") }

	var text by remember { mutableStateOf<String?>(null) }
	TextField(
		label = "Text field",
		text = text,
		onChange = { text = it },
		supportingText = parameters.named("Supporting text", "").takeIf { parameters.named("Display supporting text", false) },
		errorText = parameters.named("Error text", "").takeIf { parameters.named("Display error text", false) },
		style = parameters.named("Style", FieldStyle.Outlined),
		leadingIcon = leadingIcon.takeIf { parameters.named("Show leading icon", false) },
		trailingIcon = trailingIcon.takeIf { parameters.named("Show trailing icon", defaultValue = false) },
	)

	parameters.draw()
}

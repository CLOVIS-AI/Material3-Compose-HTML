package opensavvy.material3.tailwind.demo.components.inputs

import androidx.compose.runtime.*
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.material3.tailwind.demo.utils.named
import opensavvy.material3.tailwind.demo.utils.rememberParameters
import opensavvy.material3.tailwind.inputs.FieldStyle
import opensavvy.material3.tailwind.inputs.TextField
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

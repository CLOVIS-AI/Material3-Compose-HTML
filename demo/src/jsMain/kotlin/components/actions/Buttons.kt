package opensavvy.material3.tailwind.demo.components.actions

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import opensavvy.material3.html.actions.buttons.*
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.material3.tailwind.demo.utils.named
import opensavvy.material3.tailwind.demo.utils.progress
import opensavvy.material3.tailwind.demo.utils.rememberParameters

@Composable
fun Buttons() = Section("Buttons") {
	val parameters = rememberParameters()

	ButtonGroup {
		ElevatedButton(
			"Elevated button",
			action = { window.alert("Clicked") },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		FilledButton(
			"Filled button",
			action = { window.alert("Clicked") },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		FilledTonalButton(
			"Filled tonal button",
			action = { window.alert("Clicked") },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		OutlinedButton(
			"Outlined button",
			action = { window.alert("Clicked") },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		TextButton(
			"Text button",
			action = { window.alert("Clicked") },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)
	}

	parameters.draw()
}

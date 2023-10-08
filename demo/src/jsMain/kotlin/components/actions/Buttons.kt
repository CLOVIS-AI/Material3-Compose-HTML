package opensavvy.material3.tailwind.demo.components.actions

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import opensavvy.material3.tailwind.actions.buttons.*

@Composable
fun Buttons() {
	ElevatedButton(
		"Elevated button",
		action = { window.alert("Clicked") },
	)

	FilledButton(
		"Filled button",
		action = { window.alert("Clicked") },
	)

	FilledTonalButton(
		"Filled tonal button",
		action = { window.alert("Clicked") },
	)

	OutlinedButton(
		"Outlined button",
		action = { window.alert("Clicked") },
	)

	TextButton(
		"Text button",
		action = { window.alert("Clicked") },
	)
}

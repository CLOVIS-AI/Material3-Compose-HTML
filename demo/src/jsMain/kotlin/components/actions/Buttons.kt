package opensavvy.material3.demo.components.actions

import androidx.compose.runtime.Composable
import opensavvy.material3.demo.utils.Section
import opensavvy.material3.demo.utils.named
import opensavvy.material3.demo.utils.progress
import opensavvy.material3.demo.utils.rememberParameters
import opensavvy.material3.html.actions.buttons.*
import opensavvy.material3.html.communication.snackbar.rememberSnackbarCreator

@Composable
fun Buttons() = Section("Buttons") {
	val parameters = rememberParameters()
	val snackbarCreator = rememberSnackbarCreator()

	ButtonGroup {
		ElevatedButton(
			"Elevated button",
			action = { snackbarCreator.create("Clicked on the elevated button!", autoDismiss = true) },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		FilledButton(
			"Filled button",
			action = { snackbarCreator.create("Clicked on the filled button!", autoDismiss = true) },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		FilledTonalButton(
			"Filled tonal button",
			action = { snackbarCreator.create("Clicked on the filled tonal button!", autoDismiss = true) },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		OutlinedButton(
			"Outlined button",
			action = { snackbarCreator.create("Clicked on the outlined button!", autoDismiss = true) },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)

		TextButton(
			"Text button",
			action = { snackbarCreator.create("Clicked on the text button!", autoDismiss = true) },
			enabled = parameters.named("Enabled", true),
			progress = parameters.progress(),
		)
	}

	parameters.draw()
}

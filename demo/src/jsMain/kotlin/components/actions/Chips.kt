package opensavvy.material3.demo.components.actions

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import opensavvy.material3.demo.utils.Section
import opensavvy.material3.demo.utils.named
import opensavvy.material3.demo.utils.progress
import opensavvy.material3.demo.utils.rememberParameters
import opensavvy.material3.html.actions.chips.*
import opensavvy.material3.html.communication.snackbar.rememberSnackbarCreator

@Composable
fun Chips() = Section("Chips") {
	val parameters = rememberParameters()
	val scope = rememberCoroutineScope()
	val snackbarCreator = rememberSnackbarCreator()

	var filterActive by remember { mutableStateOf(true) }
	var inputVisible by remember { mutableStateOf(true) }

	ChipGroup {
		AssistChip(
			"AssistChip",
			onClick = { snackbarCreator.create("Clicked on the AssistChip!") },
			enabled = parameters.named("Enabled", true),
			contrasted = parameters.named("Contrasted", false),
			progress = parameters.progress(),
		)

		FilterChip(
			"FilterChip",
			filterActive,
			onToggle = { filterActive = it },
			enabled = parameters.named("Enabled", true),
			contrasted = parameters.named("Contrasted", false),
			progress = parameters.progress(),
		)

		if (inputVisible) {
			InputChip(
				"InputChip",
				onClick = { snackbarCreator.create("Clicked on the InputChip!", autoDismiss = true) },
				onRemove = {
					scope.launch {
						inputVisible = false
						delay(1000)
						inputVisible = true
					}
				},
				enabled = parameters.named("Enabled", true),
				contrasted = parameters.named("Contrasted", false),
				progress = parameters.progress(),
			)
		}

		SuggestionChip(
			"SuggestionChip",
			onClick = { snackbarCreator.create("Clicked on the SuggestionChip!") },
			enabled = parameters.named("Enabled", true),
			contrasted = parameters.named("Contrasted", false),
			progress = parameters.progress(),
		)
	}

	parameters.draw()
}

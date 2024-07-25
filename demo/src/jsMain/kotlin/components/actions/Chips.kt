package opensavvy.material3.tailwind.demo.components.actions

import androidx.compose.runtime.*
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import opensavvy.material3.html.actions.chips.*
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.material3.tailwind.demo.utils.named
import opensavvy.material3.tailwind.demo.utils.progress
import opensavvy.material3.tailwind.demo.utils.rememberParameters

@Composable
fun Chips() = Section("Chips") {
	val parameters = rememberParameters()
	val scope = rememberCoroutineScope()

	var filterActive by remember { mutableStateOf(true) }
	var inputVisible by remember { mutableStateOf(true) }

	ChipGroup {
		AssistChip(
			"AssistChip",
			onClick = { window.alert("Clocked") },
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
				onClick = { window.alert("Clicked") },
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
			onClick = { window.alert("Clicked") },
			enabled = parameters.named("Enabled", true),
			contrasted = parameters.named("Contrasted", false),
			progress = parameters.progress(),
		)
	}

	parameters.draw()
}

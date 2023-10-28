package opensavvy.material3.tailwind.demo.components.actions

import androidx.compose.runtime.*
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import opensavvy.material3.tailwind.actions.chips.*
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.progress.Progress
import opensavvy.progress.done
import opensavvy.progress.loading

@Composable
fun Chips() = Section("Chips") {
	val scope = rememberCoroutineScope()
	var progress: Progress by remember { mutableStateOf(done()) }

	fun action() {
		scope.launch {
			repeat(30) {
				progress = loading(1.0 / 30 * it)
				delay(50 * 60 / 30)
			}
			progress = done()
			window.alert("Clicked")
		}
	}

	var filterActive by remember { mutableStateOf(true) }
	var inputVisible by remember { mutableStateOf(true) }

	ChipGroup {
		AssistChip(
			"AssistChip",
			onClick = { action() },
			progress = progress,
		)

		FilterChip(
			"FilterChip",
			filterActive,
			onToggle = { filterActive = it },
			progress = progress,
		)

		if (inputVisible) {
			InputChip(
				"InputChip",
				onClick = { action() },
				onRemove = {
					scope.launch {
						inputVisible = false
						delay(1000)
						inputVisible = true
					}
				},
				progress = progress,
			)
		}

		SuggestionChip(
			"SuggestionChip",
			onClick = { action() },
			progress = progress,
		)
	}
}

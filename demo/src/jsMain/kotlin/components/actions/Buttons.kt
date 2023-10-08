package opensavvy.material3.tailwind.demo.components.actions

import androidx.compose.runtime.*
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import opensavvy.material3.tailwind.actions.buttons.*
import opensavvy.progress.Progress
import opensavvy.progress.done
import opensavvy.progress.loading

@Composable
fun Buttons() {
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

	ElevatedButton(
		"Elevated button",
		progress = progress,
		action = { action() },
	)

	FilledButton(
		"Filled button",
		progress = progress,
		action = { action() },
	)

	FilledTonalButton(
		"Filled tonal button",
		progress = progress,
		action = { action() },
	)

	OutlinedButton(
		"Outlined button",
		progress = progress,
		action = { action() },
	)

	TextButton(
		"Text button",
		progress = progress,
		action = { action() },
	)
}

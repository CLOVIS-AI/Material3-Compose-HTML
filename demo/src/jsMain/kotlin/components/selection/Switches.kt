package opensavvy.material3.tailwind.demo.components.selection

import androidx.compose.runtime.*
import opensavvy.material3.html.selection.Switch
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.material3.tailwind.demo.utils.named
import opensavvy.material3.tailwind.demo.utils.rememberParameters

@Composable
fun Switches() = Section("Switch") {
	val parameters = rememberParameters()
	var active by remember { mutableStateOf(false) }

	for (currentlyActive in listOf(active, !active))
		Switch(
			active = currentlyActive,
			action = { active = !active },
			enabled = parameters.named("enabled", true),
		)

	parameters.draw()
}

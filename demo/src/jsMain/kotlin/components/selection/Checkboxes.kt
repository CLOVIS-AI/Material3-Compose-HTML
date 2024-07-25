package opensavvy.material3.demo.components.selection

import androidx.compose.runtime.*
import opensavvy.material3.demo.utils.Section
import opensavvy.material3.demo.utils.named
import opensavvy.material3.demo.utils.rememberParameters
import opensavvy.material3.html.selection.Checkbox
import opensavvy.material3.html.selection.Tristate
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@Composable
fun Checkboxes() = Section("Checkbox") {
	val parameters = rememberParameters()

	var top by remember { mutableStateOf(false) }
	val nested = remember { mutableStateMapOf("First" to true, "Second" to false, "Third" to true) }

	Label {
		Checkbox(
			active = top,
			action = { top = it },
			enabled = parameters.named("enabled", true),
		)
		Text(" Item A")
	}

	Label {
		Checkbox(
			state = run {
				var isTrue = 0
				var isFalse = 0

				nested.forEach { if (it.value) isTrue++ else isFalse++ }

				when {
					isTrue == nested.size -> Tristate.Active
					isFalse == nested.size -> Tristate.Inactive
					else -> Tristate.Indeterminate
				}
			},
			action = {
				val isActive = it == Tristate.Active
				nested.forEach { (key, _) -> nested[key] = isActive }
			},
		)
		Text(" Item B")
	}

	Div({
		style {
			marginLeft(1.cssRem)
		}
	}) {
		for ((item, active) in nested) Div {
			Label {
				Checkbox(
					active = active,
					action = { nested[item] = it },
					enabled = parameters.named("enabled", true),
				)
				Text(" $item")
			}
		}
	}

	parameters.draw()
}

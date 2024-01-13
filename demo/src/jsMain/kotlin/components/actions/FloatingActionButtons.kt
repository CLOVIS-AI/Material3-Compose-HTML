package opensavvy.material3.tailwind.demo.components.actions

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import opensavvy.material3.tailwind.actions.buttons.ButtonGroup
import opensavvy.material3.tailwind.actions.fab.FloatingActionButton
import opensavvy.material3.tailwind.actions.fab.FloatingActionButtonSize
import opensavvy.material3.tailwind.actions.fab.FloatingActionButtonTheme
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.material3.tailwind.demo.utils.named
import opensavvy.material3.tailwind.demo.utils.progress
import opensavvy.material3.tailwind.demo.utils.rememberParameters
import org.jetbrains.compose.web.dom.Text

@Composable
fun FloatingActionButtons() = Section("Floating action buttons") {
	val parameters = rememberParameters()

	ButtonGroup {
		for (theme in FloatingActionButtonTheme.entries) {
			FloatingActionButton(
				label = "Action",
				tooltip = parameters.named("Tooltip", defaultValue = "FAB"),
				action = { window.alert("Clicked") },
				progress = parameters.progress(),
				showIcon = parameters.named("Show icon", defaultValue = true),
				showLabel = parameters.named("Show label", defaultValue = false),
				theme = theme,
				size = parameters.named("Size", FloatingActionButtonSize.Regular)
			) {
				Text("FAB")
			}
		}
	}

	parameters.draw()
}

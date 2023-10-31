package opensavvy.material3.tailwind.demo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import opensavvy.material3.css.ColorScheme
import opensavvy.material3.css.InstallColorScheme
import opensavvy.material3.tailwind.demo.components.actions.Buttons
import opensavvy.material3.tailwind.demo.components.actions.Chips
import opensavvy.material3.tailwind.demo.utils.SchemeSelector
import org.jetbrains.compose.web.renderComposable

fun main() {
	renderComposable(rootElementId = "root") {
		var scheme by remember { mutableStateOf(ColorScheme.System) }

		InstallColorScheme(scheme) {
			SchemeSelector(scheme, onSelect = { scheme = it })
			Buttons()
			Chips()
		}
	}
}

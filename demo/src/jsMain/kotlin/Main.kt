package opensavvy.material3.tailwind.demo

import opensavvy.material3.css.InstallColorScheme
import opensavvy.material3.tailwind.demo.components.actions.Buttons
import opensavvy.material3.tailwind.demo.components.actions.Chips
import org.jetbrains.compose.web.renderComposable

fun main() {
	renderComposable(rootElementId = "root") {
		InstallColorScheme {
			Buttons()
			Chips()
		}
	}
}

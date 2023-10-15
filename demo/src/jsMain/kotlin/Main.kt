package opensavvy.material3.tailwind.demo

import opensavvy.material3.tailwind.demo.components.actions.Buttons
import org.jetbrains.compose.web.renderComposable

fun main() {
	renderComposable(rootElementId = "root") {
		Buttons()
	}
}
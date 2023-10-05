package opensavvy.material3.tailwind.demo

import kotlinx.browser.window
import opensavvy.material3.tailwind.actions.buttons.TextButton
import org.jetbrains.compose.web.renderComposable

fun main() {
	renderComposable(rootElementId = "root") {
		TextButton(
			"Text button",
			action = { window.alert("Clicked") }
		)
	}
}

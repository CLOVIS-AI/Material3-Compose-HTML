package opensavvy.material3.html.actions.buttons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

@Composable
internal fun AbstractButton(
	label: String,
	action: () -> Unit,
	enabled: Boolean = true,
	progress: Progress = done(),
	icon: (@Composable () -> Unit)? = null,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) {
	Button({
		this.onClick { action() }

		if (!enabled)
			this.disabled()

		classes("mdk-button")

		attrs()
	}) {
		val capitalizedLabel = remember(label) {
			label.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
		}

		icon?.invoke()

		Text(capitalizedLabel)

		if (progress != done())
			Text("…")
	}
}

package opensavvy.material3.html.actions.chips

import androidx.compose.runtime.Composable
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import opensavvy.material3.html.communication.progress.CircularProgressIndicator
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLButtonElement

@UnfinishedComponent
@ExperimentalComponent
@Composable
internal fun AbstractChip(
	enabled: Boolean,
	progress: Progress = done(),
	leading: @Composable () -> Unit = {},
	trailing: @Composable () -> Unit = {},
	main: @Composable () -> Unit,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) {
	Button({
		classes("mdk-chip")

		if (!enabled)
			disabled()

		attrs()
	}) {
		Div({
			classes("mdk-chip-leading")
		}) {
			if (progress != done())
				CircularProgressIndicator(progress)
			else
				leading()
		}

		Div({
			classes("mdk-chip-content")
		}) {
			main()
		}

		Div({
			classes("mdk-chip-trailing")
		}) {
			trailing()
		}
	}
}

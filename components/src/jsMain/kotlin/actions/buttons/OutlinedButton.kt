package opensavvy.material3.html.actions.buttons

import androidx.compose.runtime.Composable
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLButtonElement

/**
 * A button that displays a [label], and performs an [action] when the user clicks it.
 *
 * ### Usage
 *
 * Outlined buttons are medium-emphasis buttons.
 * They contain actions that are important, but aren't the primary action in an app.
 *
 * Outlined buttons pair well with filled buttons to indicate an alternative, secondary option.
 * They can be placed on a variety of backgrounds, including color gradients.
 *
 * ### External resources
 *
 * [Material3 Specs](https://m3.material.io/components/buttons/overview).
 *
 * @param label Text description of the action that will occur if the user clicks on it.
 * Capitalize the first word and proper nouns to allow distinguishing proper nouns.
 * @param icon Optional icon to help draw attention to the button.
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun OutlinedButton(
	label: String,
	action: () -> Unit,
	enabled: Boolean = true,
	progress: Progress = done(),
	icon: (@Composable () -> Unit)? = null,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
)= AbstractButton(
	label, action, enabled, progress, icon
) {
	classes("mdk-button-outlined")

	attrs()
}

package opensavvy.material3.html.actions.buttons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

/**
 * A button that displays a [label], and performs an [action] when the user clicks it.
 *
 * ### Usage
 *
 * Text buttons are used for the lowest priority actions, especially when presenting multiple options.
 * Text buttons can be placed on a variety of backgrounds. Until the button is interacted with, its
 * container isn't visible.
 *
 * Text buttons are often embedded in components like cards, dialogs, and snackbars.
 * Because text buttons don't have a visible container in their default state,
 * they don't distract from nearby content.
 *
 * In cards, text buttons help maintain an emphasis on card content.
 * Dialogs use text buttons because the absence of a container helps unify the action with the dialog text.
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
fun TextButton(
	label: String,
	action: () -> Unit,
	enabled: Boolean = true,
	progress: Progress = done(),
	icon: (@Composable () -> Unit)? = null,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) = AbstractButton(
	label, action, enabled, progress, icon
) {
	classes("mdk-button-text")

	attrs()
}

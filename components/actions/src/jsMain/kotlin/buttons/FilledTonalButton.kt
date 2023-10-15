package opensavvy.material3.tailwind.actions.buttons

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLButtonElement

/**
 * A button that displays a [label], and performs an [action] when the user clicks it.
 *
 * ### Usage
 *
 * A filled tonal button is an alternative middle ground between filled and outlined buttons.
 * They're useful in contexts where a lower-priority button requires slightly more emphasis than an outline would give,
 * such as "Next" in an onboarding flow.
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
fun FilledTonalButton(
	label: String,
	action: () -> Unit,
	enabled: Boolean = true,
	progress: Progress = done(),
	icon: (@Composable () -> Unit)? = null,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) {
	// For now, it's just an alias for a text button
	TextButton(label, action, enabled, progress, icon, attrs)
}

package opensavvy.material3.tailwind.actions.buttons

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.w3c.dom.HTMLButtonElement

/**
 * A button that displays a [label], and performs an [action] when the user clicks it.
 *
 * ### Usage
 *
 * Elevated buttons are filled tonal buttons with a shadow. To prevent shadow creep, only use them when
 * absolutely necessary, such as when the button requires visual separation from patterned background.
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
fun ElevatedButton(
	label: String,
	action: () -> Unit,
	enabled: Boolean = true,
	icon: (@Composable () -> Unit)? = null,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) {
	// For now, it's just an alias for a text button
	TextButton(label, action, enabled, icon, attrs)
}

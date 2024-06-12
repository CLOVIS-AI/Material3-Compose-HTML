package opensavvy.material3.tailwind.actions.chips

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import opensavvy.material3.tailwind.communication.progress.CircularProgressIndicator
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

/**
 * Smart or automated actions that can span multiple apps,
 * such as opening a calendar event from the home screen.
 *
 * ### Differences with buttons
 *
 * While buttons are expected to appear consistently with familiar calls to action,
 * chips appear dynamically as a group of multiple interactive elements.
 *
 * Chips should appear in groups, whereas there should be no more than 3 buttons
 * in a single arrangement.
 *
 * Chips are reactive and contextual, whereas buttons are static and predetermined.
 * A chip should offer a different action depending on the nature of content it supports,
 * whereas a button should be a permanent fixture of layout.
 * A chip represents forking paths in an experience,
 * while a button represents a linear step in a flow.
 *
 * ### Usage
 *
 * Assist functions as though the user asked an assistant to complete the action.
 * They should appear dynamically and contextually.
 *
 * Assist chips should be displayed after primary content, such as below a card
 * or persistently at the bottom of a screen.
 *
 * ### External resources
 *
 * [Material3 Specs](https://m3.material.io/components/chips).
 *
 * @param label Text description of the filter that is active while the chip is visible.
 * @param icon Optional icon to help draw attention to the button.
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun AssistChip(
	label: String,
	onClick: () -> Unit,
	enabled: Boolean = true,
	contrasted: Boolean = false,
	progress: Progress = done(),
	icon: (@Composable () -> Unit)? = null,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) {
	Button({
		this.onClick { onClick() }

		if (!enabled)
			this.disabled()

		classes("mdk-chip-assist")

		attrs()
	}) {
		if (progress is Progress.Loading)
			CircularProgressIndicator(progress)
		else if (icon != null)
			icon()

		Text(label)
	}
}

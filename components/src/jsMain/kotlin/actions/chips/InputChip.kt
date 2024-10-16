package opensavvy.material3.html.actions.chips

import androidx.compose.runtime.Composable
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLButtonElement

/**
 * A search filter created by the user named [label].
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
 * Use input chips to represent filters created by the user.
 * The user can either click on the chip itself (see [onClick]),
 * or click on the cross to remove the chip (see [onRemove]).
 *
 * Input chips can support editing their contents.
 * In edit mode, the chip reverts to an editable text string.
 *
 * To represent filters created by the application, see [InputChip].
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
fun InputChip(
	label: String,
	onClick: () -> Unit,
	onRemove: () -> Unit,
	enabled: Boolean = true,
	contrasted: Boolean = false,
	progress: Progress = done(),
	icon: (@Composable () -> Unit)? = null,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) {
	AbstractChip(
		enabled = enabled,
		progress = progress,
		leading = { icon?.invoke() },
		trailing = {
			Span({ // TODO: Bad for accessibility, fix after #13
				onClick { onRemove() }
			}) {
				Text("×")
			}
		},
		main = { Text(label) },
		attrs = {
			classes("mdk-chip-input")
			onClick { onClick() }
			attrs()
		}
	)
}

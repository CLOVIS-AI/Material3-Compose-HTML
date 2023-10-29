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
 * A search filter named [label] that can be [active] or inactive.
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
 * Use filter chips to represent filters created by the application.
 *
 * To represent filters created by the user, see [InputChip].
 *
 * In a group, either the user can select multiple chips at once, or filter chips
 * can be used as an alternative o radio buttons with only one being [active] at once.
 *
 * ### External resources
 *
 * [Material3 Specs](https://m3.material.io/components/chips).
 *
 * @param label Text description of the filter that will be enabled when [active] is `true`.
 * @param active When `true`, the filter is active and limits the elements seen.
 * When `false`, the filter is inactive and has no impact on the results of the page.
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun FilterChip(
	label: String,
	active: Boolean,
	onToggle: (Boolean) -> Unit,
	enabled: Boolean = true,
	contrasted: Boolean = false,
	progress: Progress = done(),
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
) {
	Button({
		this.onClick { onToggle(!active) }

		if (!enabled)
			this.disabled()

		classes("bg-blue-500")

		attrs()
	}) {
		if (progress is Progress.Loading)
			CircularProgressIndicator(progress)

		Text(label)
	}
}
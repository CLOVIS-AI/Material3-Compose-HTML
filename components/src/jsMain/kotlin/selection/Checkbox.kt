package opensavvy.material3.html.selection

import androidx.compose.runtime.Composable
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLInputElement

/**
 * Checkboxes let users select one or more items from a list, or turn an item on or off.
 *
 * ### Usage
 *
 * Use checkboxes to:
 * - Select one or more options from a list.
 * - Present a list containing sub-selections.
 * - Turn an item on or off in a desktop environment.
 * - Visually group similar options together.
 *
 * Checkboxes should be used instead of [switches][Switch] if multiple,
 * related options can be selected from a list. Checkboxes visually group similar items
 * effectively and take up less space than switches.
 *
 * ### The indeterminate state
 *
 * The [intermediate][Tristate.Indeterminate] state is a special state that can never be triggered by the user directly.
 * It may be used to create a 'parent' checkbox that summarizes the state of multiple nested checkboxes, allowing to check
 * or uncheck all nested values at once. When the nested checkboxes are not all in the same state, the parent checkbox may
 * use the indeterminate state.
 *
 * ### External resources
 *
 * [Material3 Spec](https://m3.material.io/components/checkbox).
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun Checkbox(
	state: Tristate,
	action: (state: Tristate.Output) -> Unit,
	enabled: Boolean = true,
	attrs: InputAttrsScope<Boolean>.() -> Unit = {},
) {
	Input(InputType.Checkbox) {
		classes("mdk-checkbox")

		checked(state == Tristate.Active) // In HTML, indeterminate and checked are cumulative. We decide that 'indeterminate' counts as inactive
		prop<HTMLInputElement, Boolean>({ element, it -> element.indeterminate = it }, state == Tristate.Indeterminate)

		onChange {
			when (state) {
				Tristate.Active -> action(Tristate.Inactive)
				Tristate.Inactive -> action(Tristate.Active)
				Tristate.Indeterminate -> action(Tristate.Active)
			}
		}

		if (!enabled)
			disabled()

		attrs()
	}
}

/**
 * Checkboxes let users select one or more items from a list, or turn an item on or off.
 *
 * ### Usage
 *
 * Use checkboxes to:
 * - Select one or more options from a list.
 * - Present a list containing sub-selections.
 * - Turn an item on or off in a desktop environment.
 * - Visually group similar options together.
 *
 * Checkboxes should be used instead of [switches][Switch] if multiple,
 * related options can be selected from a list. Checkboxes visually group similar items
 * effectively and take up less space than switches.
 *
 * ### External resources
 *
 * [Material3 Spec](https://m3.material.io/components/checkbox).
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun Checkbox(
	active: Boolean,
	action: (active: Boolean) -> Unit,
	enabled: Boolean = true,
	attrs: InputAttrsScope<Boolean>.() -> Unit = {},
) {
	Checkbox(
		state = if (active) Tristate.Active else Tristate.Inactive,
		action = { state ->
			when (state) {
				Tristate.Active -> action(true)
				Tristate.Inactive -> action(false)
			}
		},
		enabled = enabled,
		attrs = attrs,
	)
}

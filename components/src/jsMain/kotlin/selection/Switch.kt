package opensavvy.material3.tailwind.selection

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import org.jetbrains.compose.web.attributes.builders.InputAttrsScope
import org.jetbrains.compose.web.dom.CheckboxInput

/**
 * A switch toggles the selection of an item on or off.
 *
 * ### Usage
 *
 * Switches (not radio buttons) should be used if items on a list can be independently controlled.
 * They are the best way to let users adjust settings.
 *
 * Switches are best used to adjust settings and other standalone options.
 * They make a binary selection, like on and off, or true and false.
 *
 * The effects of a switch should start immediately without needing to save.
 *
 * Switches control binary options, not opposing ones.
 * A binary option represents a single selection that is either on or off.
 * Opposing options are when only one option in a set can be selected at a time, like a list of map view.
 * Opposing options should be represented with radio buttons or segmented chips.
 *
 * Switches should be paired with an inline label describing what the switch controls when selected.
 * The labels should be short and direct.
 *
 * ### External resources
 *
 * [Material3 Specs](https://m3.material.io/components/switch).
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun Switch(
	active: Boolean,
	action: (active: Boolean) -> Unit,
	enabled: Boolean = true,
	attrs: InputAttrsScope<Boolean>.() -> Unit = {},
) = CheckboxInput(active) {
	classes("outline", "outline-4", "rounded-full", "w-8")

	when {
		enabled && active -> classes("bg-primary-container-on", "text-primary-on")
		enabled && !active -> classes("text-surface-on")
		!enabled -> classes("text-surface-container-highest", "outline-outline")
	}

	onClick { action(!active) }

	attrs()
}

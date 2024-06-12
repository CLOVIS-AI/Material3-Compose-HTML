package opensavvy.material3.tailwind.actions.chips

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

/**
 * A group of related chips.
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun ChipGroup(
	attrs: AttrsScope<HTMLDivElement>.() -> Unit = {},
	block: @Composable ElementScope<HTMLDivElement>.() -> Unit,
) = Div({
	classes("mdk-chip-group")

	attrs()
}) {
	block()
}

package opensavvy.material3.html.actions.buttons

import androidx.compose.runtime.Composable
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.ElementScope
import org.w3c.dom.HTMLDivElement

/**
 * A group of related buttons.
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun ButtonGroup(
	attrs: AttrsScope<HTMLDivElement>.() -> Unit = {},
	block: @Composable ElementScope<HTMLDivElement>.() -> Unit,
) = Div({
	classes("mdk-button-group")

	attrs()
}) {
	block()
}

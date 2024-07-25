package opensavvy.material3.html.communication.badges

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

/**
 * Notifies the user that some action awaits them in [block].
 *
 * If [count] is `null`, a small red circle if displayed.
 * If [count] is non-`null`, a larger circle displays the value of [count].
 *
 * Only counts in `-999..999` can be displayed. Fewer or greater counts are shortened to fit the available space.
 *
 * ### Usage
 *
 * Badges are used to indicate a notification, item count, or other information relating to
 * a navigation destination.
 *
 * Badges are most commonly used within other components, such as navigation bars, navigation rails, and tabs.
 *
 * ### External resources
 *
 * - [Material3 Specs](https://m3.material.io/components/badges)
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun Badge(
	count: Int? = null,
	block: @Composable () -> Unit,
) {
	val displayedText = remember(count) {
		when {
			count == null -> null
			count >= 1000 -> "999+"
			count <= -1000 -> "-999"
			else -> count.toString()
		}
	}

	Div({
		classes("mdk-badge-anchor")
	}) {
		block()

		Div({
			classes("mdk-badge")

			when (displayedText) {
				null -> classes("mdk-badge-small")
				else -> classes("mdk-badge-large")
			}
		}) {
			if (displayedText != null)
				Text(displayedText)
		}
	}
}

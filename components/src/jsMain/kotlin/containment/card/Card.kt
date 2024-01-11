package opensavvy.material3.tailwind.containment.card

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import opensavvy.material3.tailwind.containment.card.CardStyle.*
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Article
import org.w3c.dom.HTMLElement

/**
 * A cohesive group of information.
 *
 * ### Usage
 *
 * Cards display content and actions on a single topic.
 *
 * Cards should be easy to scan for relevant and actionable information.
 * Elements like text and images should be placed on cards in a way that clearly indicates hierarchy.
 *
 * Cards can serve as entry points into deeper levels of detail or navigation, such as a music album or details
 * on an upcoming vacation.
 *
 * Cards can be displayed together in a grid, vertical list, or carousel.
 * However, you shouldn't force content into cards when spacing, headlines, or dividers would create a simpler visual hierarchy.
 *
 * ### Style
 *
 * There are multiple [styles][CardStyle] of cards.
 * Each provides the same legibility and functionality, so the type you use depends on style alone.
 *
 * ### External resources
 *
 * [Material3 Spec](https://m3.material.io/components/cards/overview).
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun Card(
	style: CardStyle = Outlined,
	attrs: AttrsScope<HTMLElement>.() -> Unit = {},
	content: @Composable () -> Unit,
) = Article({
	classes("flex", "flex-col", "gap-1")

	when (style) {
		Elevated -> classes("bg-surface-container")
		Filled -> classes("bg-surface-container-highest")
		Outlined -> classes("outline", "outline-1", "outline-outline-variant")
	}

	attrs()
}) {
	content()
}

/**
 * Multiple card styles.
 */
enum class CardStyle {
	/**
	 * Elevated cards have a drop shadow, providing more separation from the background than filled cards, but less than outline cards.
	 */
	Elevated,

	/**
	 * Filled cards provide subtle separation from the background. This has less emphasis than elevated or outlined cards.
	 */
	Filled,

	/**
	 * Outlined cards have a visual boundary around the container. This can provide greater emphasis than other types.
	 */
	Outlined,
}

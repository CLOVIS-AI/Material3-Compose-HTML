package opensavvy.material3.html.containment.dividers

import androidx.compose.runtime.Composable
import opensavvy.material3.html.ExperimentalComponent
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Hr
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLHRElement

/**
 * A horizontal line to visually group components and create hierarchy.
 *
 * ### Usage
 *
 * Use dividers to separate larger sections of unrelated content.
 * For example, between emails in a long list.
 * They can be used directly on a surface or inside other components like cards or lists.
 *
 * They are used to group visual elements together, and indicate when elements
 * are related to each other from an interaction perspective but not a content perspective.
 * For example, emails are different content unrelated from each other, but an interaction
 * on any email is similar to one on any other email.
 *
 * Use full-width dividers to separate interactive and non-interactive areas of a container, such as a card.
 * Avoid using too many dividers, as they risk make an interface look cluttered.
 *
 * ### Alternatives
 *
 * To create a division inside related content, use [InsetDivider] instead.
 *
 * ### External resources
 *
 * [Material3 Spec](https://m3.material.io/components/divider).
 */
@ExperimentalComponent
@Composable
fun Divider(
	attrs: AttrsScope<HTMLDivElement>.() -> Unit = {},
) {
	// Why not an HR? For accessibility.
	// HR is a "thematic break between paragraph-level elements" -> that's an inset divider.
	// Regular divider is purely visual decoration, it has no semantic meaning.
	Div({
		classes("mdk-divider")

		attrs()
	})
}

/**
 * A horizontal line to separate related content within a section.
 *
 * ### usage
 *
 * Inset dividers separate related content, such as a product description and a list of related actions.
 *
 * ### Alternatives
 *
 * To create a division between sections of unrelated content, use [Divider] instead.
 *
 * ### External resources
 *
 * [Material3 Spec](https://m3.material.io/components/divider).
 */
@ExperimentalComponent
@Composable
fun InsetDivider(
	attrs: AttrsScope<HTMLHRElement>.() -> Unit = {},
) {
	Hr {
		classes("mdk-divider", "mdk-divider-inset")

		attrs()
	}
}

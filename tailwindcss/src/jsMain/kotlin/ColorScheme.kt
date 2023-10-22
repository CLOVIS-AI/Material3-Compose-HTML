package opensavvy.material3.css

import androidx.compose.runtime.Composable
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * Initializes the Material3 color theme.
 *
 * All components used inside [content] will respect the selected [scheme].
 */
@Composable
fun InstallColorScheme(
	scheme: ColorScheme = ColorScheme.System,
	content: ContentBuilder<HTMLDivElement>,
) = Div({
	val isDark = when (scheme) {
		ColorScheme.Light -> false
		ColorScheme.Dark -> true
		ColorScheme.System -> window.matchMedia("(prefers-color-scheme: dark)").matches
	}

	style {
		fun aliasVariable(name: String, light: String, dark: String) {
			variable("--md-token-$name", "var(--md-ref-palette-${if (isDark) dark else light})")
		}

		// Special
		aliasVariable("scrim", "neutral0", "neutral0")
		aliasVariable("shadow", "neutral0", "neutral10")
		aliasVariable("outline", "neutral-variant50", "neutral-variant60")
		aliasVariable("outline-variant", "neutral-variant80", "neutral-variant30")

		// Background
		aliasVariable("background", "neutral98", "neutral6")
		aliasVariable("background-on", "neutral10", "neutral90")

		// Primary colors
		aliasVariable("primary", "primary40", "primary80")
		aliasVariable("primary-container", "primary90", "primary30")
		aliasVariable("primary-on", "primary100", "primary20")
		aliasVariable("primary-container-on", "primary10", "primary90")
		aliasVariable("primary-inverse", "primary80", "primary40")
		aliasVariable("primary-fixed", "primary90", "primary90")
		aliasVariable("primary-fixed-dim", "primary80", "primary80")
		aliasVariable("primary-fixed-on", "primary10", "primary10")
		aliasVariable("primary-fixed-on-variant", "primary30", "primary30")

		// Secondary colors
		aliasVariable("secondary", "secondary40", "secondary80")
		aliasVariable("secondary-container", "secondary90", "secondary30")
		aliasVariable("secondary-on", "secondary100", "secondary20")
		aliasVariable("secondary-container-on", "secondary10", "secondary90")
		aliasVariable("secondary-inverse", "secondary80", "secondary40")
		aliasVariable("secondary-fixed", "secondary90", "secondary90")
		aliasVariable("secondary-fixed-dim", "secondary80", "secondary80")
		aliasVariable("secondary-fixed-on", "secondary10", "secondary10")
		aliasVariable("secondary-fixed-on-variant", "secondary30", "secondary30")

		// Tertiary colors
		aliasVariable("tertiary", "tertiary40", "tertiary80")
		aliasVariable("tertiary-container", "tertiary90", "tertiary30")
		aliasVariable("tertiary-on", "tertiary100", "tertiary20")
		aliasVariable("tertiary-container-on", "tertiary10", "tertiary90")
		aliasVariable("tertiary-inverse", "tertiary80", "tertiary40")
		aliasVariable("tertiary-fixed", "tertiary90", "tertiary90")
		aliasVariable("tertiary-fixed-dim", "tertiary80", "tertiary80")
		aliasVariable("tertiary-fixed-on", "tertiary10", "tertiary10")
		aliasVariable("tertiary-fixed-on-variant", "tertiary30", "tertiary30")

		// Error colors
		aliasVariable("error", "error40", "error80")
		aliasVariable("error-container", "error90", "error30")
		aliasVariable("error-on", "error100", "error20")
		aliasVariable("error-container-on", "error10", "error90")

		// Surface
		aliasVariable("surface", "neutral98", "neutral6")
		aliasVariable("surface-variant", "neutral-variant90", "neutral-variant30")
		aliasVariable("surface-on", "neutral10", "neutral90")
		aliasVariable("surface-variant-on", "neutral-variant30", "neutral-variant80")
		aliasVariable("surface-inverse", "neutral20", "neutral90")
		aliasVariable("surface-inverse-on", "neutral95", "neutral20")
		aliasVariable("surface-tint", "primary40", "primary80")
		aliasVariable("surface-dim", "neutral87", "neutral6")
		aliasVariable("surface-bright", "neutral98", "neutral24")
		aliasVariable("surface-container-lowest", "neutral100", "neutral4")
		aliasVariable("surface-container-low", "neutral96", "neutral10")
		aliasVariable("surface-container", "neutral94", "neutral12")
		aliasVariable("surface-container-high", "neutral92", "neutral17")
		aliasVariable("surface-container-highest", "neutral90", "neutral22")
	}
}, content)

/**
 * The user's preference to decide the color scheme.
 */
enum class ColorScheme {
	/** The user prefers dark text on a light background. */
	Light,
	/** The user prefers light text on a dark background. */
	Dark,
	/** The user has not specified their preference, we should use their browser's or OS' default. */
	System,
}

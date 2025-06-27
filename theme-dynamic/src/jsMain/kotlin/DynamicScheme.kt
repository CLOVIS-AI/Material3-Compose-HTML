package opensavvy.material3.theme

import androidx.compose.runtime.Composable
import opensavvy.material3.colors.argb.Argb
import opensavvy.material3.colors.dynamiccolor.DynamicScheme
import opensavvy.material3.colors.palettes.TonalPalette
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

/**
 * Configures all components inside [content] to use the provided [palette] and [scheme].
 *
 * In Material3, all colors are based on a [palette], which defines three primary colors,
 * an error color, and two neutral colors. The light and dark schemes are created by using
 * different tones of the colors specified by the palette.
 */
@Composable
fun InstallDynamicScheme(
	palette: DynamicScheme,
	scheme: ColorScheme = ColorScheme.System,
	content: ContentBuilder<HTMLDivElement>,
) {
	Div({
		style {
			fun tonesOf(prefix: String, palette: TonalPalette, tones: Iterable<Int>) {
				for (tone in tones) {
					variable(prefix + tone, palette.tone(tone).css)
				}
			}

			val commonTones = listOf(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 95, 99, 100)
			tonesOf("--mdk-ref-primary", palette.primaryPalette, commonTones)
			tonesOf("--mdk-ref-secondary", palette.secondaryPalette, commonTones)
			tonesOf("--mdk-ref-tertiary", palette.tertiaryPalette, commonTones)
			tonesOf("--mdk-ref-error", palette.errorPalette, commonTones)
			tonesOf("--mdk-ref-neutral", palette.neutralPalette, commonTones + listOf(4, 6, 12, 17, 22, 24, 87, 92, 94, 95, 96, 98))
			tonesOf("--mdk-ref-neutral-variant", palette.neutralVariantPalette, commonTones)
		}
	}) {
		InstallColorScheme(scheme, content)
	}
}

private val Argb.css: String
	get() = "rgb($red $green $blue)"

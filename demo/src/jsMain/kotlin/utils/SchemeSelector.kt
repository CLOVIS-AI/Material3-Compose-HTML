package opensavvy.material3.demo.utils

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable
import opensavvy.material3.colors.argb.Argb
import opensavvy.material3.colors.dynamiccolor.DynamicScheme
import opensavvy.material3.colors.hct.Hct
import opensavvy.material3.colors.scheme.*
import opensavvy.material3.html.actions.chips.ChipGroup
import opensavvy.material3.html.actions.chips.FilterChip
import opensavvy.material3.theme.ColorScheme
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Serializable
data class PalettePreference(
	val paletteName: String,
	val mainRgb: Int,
	val mode: String,
	val contrastLevel: Double,
) {

	fun asPalette(): Palette {
		val mainColor = Hct(Argb(mainRgb))
		val scheme = ColorScheme.valueOf(mode)

		return when (paletteName) {
			"Expressive" -> Palette(this, BuiltInScheme.schemeExpressive(mainColor, false, contrastLevel), scheme)
			"Fidelity" -> Palette(this, BuiltInScheme.schemeFidelity(mainColor, false, contrastLevel), scheme)
			"FruitSalad" -> Palette(this, BuiltInScheme.schemeFruitSalad(mainColor, false, contrastLevel), scheme)
			"Monochrome" -> Palette(this, BuiltInScheme.schemeMonochrome(mainColor, false, contrastLevel), scheme)
			"Neutral" -> Palette(this, BuiltInScheme.schemeNeutral(mainColor, false, contrastLevel), scheme)
			"Rainbow" -> Palette(this, BuiltInScheme.schemeRainbow(mainColor, false, contrastLevel), scheme)
			"TonalSpot" -> Palette(this, BuiltInScheme.schemeTonalSpot(mainColor, false, contrastLevel), scheme)
			"Vibrant" -> Palette(this, BuiltInScheme.schemeVibrant(mainColor, false, contrastLevel), scheme)
			else -> Palette(this, BuiltInScheme.schemeContent(mainColor, false, contrastLevel), scheme)
		}
	}

	companion object {
		val Default = PalettePreference(
			paletteName = "Content",
			mainRgb = Argb(154, 130, 219).argb,
			mode = ColorScheme.System.name,
			contrastLevel = 1.0,
		)
	}
}

private val palettes = listOf("TonalSpot", "Content", "Rainbow", "Fidelity", "FruitSalad", "Vibrant", "Expressive", "Neutral", "Monochrome")

class Palette(
	val preference: PalettePreference,
	val colors: DynamicScheme,
	val scheme: ColorScheme,
)

@Composable
fun PaletteSelector(
	current: Palette,
	onSelect: (PalettePreference) -> Unit,
) = Section("Color scheme") {
	P {
		Text("With Material3, a single color palette is used to define every color shade used by the application.")
		Text(" From this palette, a light and dark theme are generated automatically.")
	}

	P {
		Text("The user can adapt Material3 to their likes and needs through different customization points.")
		Text(" The main one is the ability to select a primary color which influences all other colors in the application.")
	}

	Text("Choose a main color:")
	Input(InputType.Color) {
		classes("mdk-chip")

		value(Argb(current.preference.mainRgb).toString())
		onInput {
			val red = it.value.slice(1..2).toInt(16)
			val green = it.value.slice(3..4).toInt(16)
			val blue = it.value.slice(5..6).toInt(16)

			onSelect(current.preference.copy(mainRgb = Argb(red, green, blue).argb))
		}

		style {
			backgroundColor(Color.transparent)
		}
	}

	P {
		Text("From that single color, multiple palettes are automatically generated.")
		Text(" Each palette represents a different atmosphere based on the selected color.")
	}

	ChipGroup {
		for (palette in palettes) {
			FilterChip(
				palette,
				active = current.preference.paletteName == palette,
				onToggle = { onSelect(current.preference.copy(paletteName = palette)) },
			)
		}
	}

	P {
		Text("Each palette supports light and dark modes out of the box.")
	}

	ChipGroup {
		for (scheme in ColorScheme.entries) {
			FilterChip(
				scheme.name,
				active = current.preference.mode == scheme.name,
				onToggle = { onSelect(current.preference.copy(mode = scheme.name)) },
			)
		}
	}
}

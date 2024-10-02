package opensavvy.material3.demo

import androidx.compose.runtime.*
import kotlinx.browser.localStorage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import opensavvy.material3.demo.components.actions.Buttons
import opensavvy.material3.demo.components.actions.Chips
import opensavvy.material3.demo.components.actions.FloatingActionButtons
import opensavvy.material3.demo.components.communication.Badges
import opensavvy.material3.demo.components.communication.LoadingIndicators
import opensavvy.material3.demo.components.containment.Cards
import opensavvy.material3.demo.components.containment.Dividers
import opensavvy.material3.demo.components.inputs.Fields
import opensavvy.material3.demo.components.selection.Checkboxes
import opensavvy.material3.demo.components.selection.Switches
import opensavvy.material3.demo.utils.PalettePreference
import opensavvy.material3.demo.utils.PaletteSelector
import opensavvy.material3.html.communication.snackbar.SnackbarHost
import opensavvy.material3.theme.InstallDynamicScheme
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
	renderComposable(rootElementId = "root") {
		var palettePreference by remember { mutableStateOf(loadPreferences()) }
		val palette = remember(palettePreference) { palettePreference.asPalette() }
		LaunchedEffect(palettePreference) { savePreferences(palettePreference) }

		InstallDynamicScheme(palette.colors, palette.scheme) {
			SnackbarHost {
				H1 {
					Text("Material3 for Compose HTML")
				}

				Intro()
				PaletteSelector(palette, onSelect = { palettePreference = it })
				Buttons()
				FloatingActionButtons()
				Chips()
				Badges()
				LoadingIndicators()
				Cards()
				Dividers()
				Switches()
				Checkboxes()
				Fields()
			}
		}
	}
}

private fun loadPreferences(): PalettePreference =
	localStorage.getItem("scheme")
		?.let { loaded ->
			try {
				Json.decodeFromString<PalettePreference>(loaded)
			} catch (e: Exception) {
				null
			}
		} ?: PalettePreference.Default

private fun savePreferences(palette: PalettePreference) {
	localStorage.setItem("scheme", Json.encodeToString(palette))
}

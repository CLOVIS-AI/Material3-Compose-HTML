package opensavvy.material3.demo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import opensavvy.material3.demo.components.actions.Buttons
import opensavvy.material3.demo.components.actions.Chips
import opensavvy.material3.demo.components.actions.FloatingActionButtons
import opensavvy.material3.demo.components.communication.LoadingIndicators
import opensavvy.material3.demo.components.containment.Cards
import opensavvy.material3.demo.components.containment.Dividers
import opensavvy.material3.demo.components.inputs.Fields
import opensavvy.material3.demo.components.selection.Checkboxes
import opensavvy.material3.demo.components.selection.Switches
import opensavvy.material3.demo.components.communication.Badges
import opensavvy.material3.demo.utils.SchemeSelector
import opensavvy.material3.html.communication.snackbar.SnackbarHost
import opensavvy.material3.theme.ColorScheme
import opensavvy.material3.theme.InstallColorScheme
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
	renderComposable(rootElementId = "root") {
		var scheme by remember { mutableStateOf(ColorScheme.System) }

		InstallColorScheme(scheme) {
			SnackbarHost {
				H1 {
					Text("Material3 for Compose HTML")
				}

				SchemeSelector(scheme, onSelect = { scheme = it })
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

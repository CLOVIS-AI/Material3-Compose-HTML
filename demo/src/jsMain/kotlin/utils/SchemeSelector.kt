package opensavvy.material3.demo.utils

import androidx.compose.runtime.Composable
import opensavvy.material3.html.actions.chips.ChipGroup
import opensavvy.material3.html.actions.chips.FilterChip
import opensavvy.material3.theme.ColorScheme
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SchemeSelector(
	current: ColorScheme,
	onSelect: (ColorScheme) -> Unit,
) = Section("Color scheme") {
	P {
		Text("With Material3, a single color palette is used to define every color shade used by the application.")
		Text(" From this palette, a light and dark theme are generated automatically.")
	}

	P {
		Text("You can programmatically replace the color palette, and all components will adapt.")
		Text(" In the future, it may be possible for end users to select their own preferred primary, secondary and tertiary colors, from which a customized palette may be generated.")
	}

	Text("Choose a theme:")
	ChipGroup {
		for (scheme in ColorScheme.entries) {
			FilterChip(scheme.name, active = current == scheme, onToggle = { onSelect(scheme) })
		}
	}
}

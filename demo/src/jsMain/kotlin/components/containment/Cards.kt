package opensavvy.material3.tailwind.demo.components.containment

import androidx.compose.runtime.Composable
import opensavvy.material3.html.communication.progress.LinearProgressIndicator
import opensavvy.material3.html.containment.card.Card
import opensavvy.material3.html.containment.card.CardStyle
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.material3.tailwind.demo.utils.progress
import opensavvy.material3.tailwind.demo.utils.rememberParameters
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text

@Composable
fun Cards() = Section("Cards") {
	val parameters = rememberParameters()

	Div({
		classes("demo-cards")
	}) {
		for (style in CardStyle.entries) {
			Card(style) {
				H3 {
					Text("Card title")
				}

				H4 { Text("Style: $style") }

				LinearProgressIndicator(parameters.progress())

				Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis a eros tempus, aliquet orci vitae, feugiat mauris. Vestibulum at elit sodales, dapibus dui ut, varius risus. Vivamus in odio vel ante sollicitudin pretium. Curabitur nec arcu varius, molestie risus ac, rutrum neque. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam pharetra risus vel leo molestie, sit amet efficitur sapien aliquam.")
			}
		}
	}

	parameters.draw()
}

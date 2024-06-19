package opensavvy.material3.tailwind.demo.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun Section(
	title: String,
	block: @Composable () -> Unit,
) = Article {
	H2 {
		Text(title)
	}

	block()
}

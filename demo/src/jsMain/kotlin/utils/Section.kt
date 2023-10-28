package opensavvy.material3.tailwind.demo.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Article
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Section(
	title: String,
	block: @Composable () -> Unit,
) = Article({

}) {
	P({
		classes("text-4xl", "text-extrabold", "mt-4", "mb-2")
	}) {
		Text(title)
	}

	block()
}

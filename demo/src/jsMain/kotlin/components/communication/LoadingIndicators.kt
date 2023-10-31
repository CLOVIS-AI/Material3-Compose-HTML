package opensavvy.material3.tailwind.demo.components.communication

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import opensavvy.material3.tailwind.communication.progress.CircularProgressIndicator
import opensavvy.material3.tailwind.communication.progress.LinearProgressIndicator
import opensavvy.material3.tailwind.demo.utils.Section
import opensavvy.progress.Progress
import opensavvy.progress.done
import opensavvy.progress.loading
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.random.nextLong

@Composable
fun LoadingIndicators() = Section("Loading indicators") {
	var progress: Progress by remember { mutableStateOf(done()) }

	LaunchedEffect(Unit) {
		while (isActive) {
			// try to generate multiple steps to look realistic
			val steps = List(Random.nextInt(3..7)) { Random.nextInt(1..30) }
			val total = steps.sum()
			val normalizedSteps = steps.map { it.toDouble() / total }
			var current = 0.0
			for (step in normalizedSteps) {
				current += step
				progress = loading(current.coerceAtMost(1.0))
				delay(Random.nextLong(500L..2000L))
			}

			progress = done()
			delay(3000)
		}
	}

	Div {
		LinearProgressIndicator(progress)
		CircularProgressIndicator(progress)
	}

	Div {
		Text("Indeterminate variants:")
		val indeterminate = when (progress) {
			is Progress.Done -> done()
			else -> loading()
		}
		LinearProgressIndicator(indeterminate)
		CircularProgressIndicator(indeterminate)
	}
}

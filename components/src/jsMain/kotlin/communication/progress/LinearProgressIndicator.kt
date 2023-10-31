package opensavvy.material3.tailwind.communication.progress

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import opensavvy.progress.Progress
import org.jetbrains.compose.web.dom.Text

/**
 * Display [progress] to the user (horizontal indicator).
 *
 * ### Usage
 *
 * Progress indicators capture attention through motion.
 * Never use them as decoration.
 *
 * ### External resources
 *
 * [Material3 Specs](https://m3.material.io/components/progress-indicators/overview).
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun LinearProgressIndicator(progress: Progress) {
	when (progress) {
		is Progress.Done -> { /* Nothing to display */ }
		is Progress.Loading.Unquantified -> Text("Loading…")
		is Progress.Loading.Quantified -> Text("Loading ${progress.percent}%…")
	}
}

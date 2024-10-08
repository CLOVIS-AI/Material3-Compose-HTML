package opensavvy.material3.html.communication.progress

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.svg.Line
import org.jetbrains.compose.web.svg.Svg

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
@ExperimentalComposeWebSvgApi
@Composable
fun LinearProgressIndicator(progress: Progress) = Svg("0 0 100 10", {
	attr("preserveAspectRatio", "none")

	classes("mdk-progress-linear")

	if (progress == done())
		classes("mdk-progress-linear-done")
}) {
	// Track
	Line(0, 5, 100, 5, attrs = {
		classes("mdk-progress-linear-track")
	})

	// Positions
	var startPos by remember { mutableStateOf(0.0) }
	var endPos by remember { mutableStateOf(0.0) }
	var animationStep by remember { mutableStateOf(0) }

	LaunchedEffect(progress, animationStep) {
		when (progress) {
			is Progress.Done -> {
				delay(500) // give some time to the appearance/disappearance animation to finish
				startPos = 0.0
				endPos = 0.0
				animationStep = 0
			}

			is Progress.Loading.Quantified -> {
				startPos = 0.0
				endPos = progress.normalized
			}

			is Progress.Loading.Unquantified -> {
				launch {
					delay(1000)
					animationStep = (animationStep + 1) % 3
				}

				// Steps:
				// 0: nothing (cursor on the left)
				// 1: full
				// 2: nothing (cursor on the right)

				startPos = when (animationStep) {
					1 -> 1.0
					else -> 0.0
				}

				endPos = when (animationStep) {
					0 -> 1.0
					else -> 0.0
				}
			}
		}
	}

	// Active indicator
	Line(0, 5, 100, 5, attrs = {
		classes("mdk-progress-linear-indicator")

		style {
			variable("--mdk-progress-linear-start-pos", "${(startPos * 100).toInt()}%")
			variable("--mdk-progress-linear-end-pos", endPos)
		}
	})
}

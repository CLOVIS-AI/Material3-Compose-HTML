package opensavvy.material3.tailwind.communication.progress

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
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
@OptIn(ExperimentalComposeWebSvgApi::class)
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun LinearProgressIndicator(progress: Progress) = Svg("0 0 100 10", {
	attr("preserveAspectRatio", "none")
	classes(
		"w-full",
		"transition-all",
	)

	if (progress != done()) {
		classes("h-1", "my-0")
	} else {
		classes("h-0", "mt-0.5", "mb-0.5")
	}
}) {
	// Track
	Line(0, 5, 100, 5, attrs = {
		classes("stroke-surface-container-highest", "stroke-[10px]")
	})

	// Active indicator
	Line(0, 5, if (progress is Progress.Loading.Quantified) progress.percent else 100, 5, attrs = {
		classes("stroke-primary", "stroke-[10px]", "transition-all")
	})
}

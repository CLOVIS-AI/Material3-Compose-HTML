package opensavvy.material3.tailwind.actions.fab

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import opensavvy.material3.tailwind.communication.progress.CircularProgressIndicator
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Button
import org.w3c.dom.HTMLButtonElement

/**
 * Help people find the primary action.
 *
 * ### Usage
 *
 * Use the Floating Action Button (FAB) for the most common or important action on a screen.
 * It appears in front of all other content and is recognizable for its rounded shape and centered icon.
 * Do not use FABs when the action is available elsewhere on the screen.
 *
 * Make sure the icon is clear and understandable.
 * Use the [tooltip] to provide a text description.
 *
 * FABs are not needed on every screen.
 * If the primary action is already clear, do not add one.
 *
 * ### Action
 *
 * A FAB can trigger an [action] either in the current screen, or it can perform an action
 * that creates a new screen.
 *
 * A FAB promotes an important, constructive action, such as "create", "favorite", "share", "start a process".
 * Avoid using FABs for minor or destructive actions, such as "archive", "trash", alerts and errors, limited tasks
 * like cutting text.
 *
 * ### Position
 *
 * Do not use multiple FABs on a single screen.
 * In rare cases, it is possible to pair a [normal FAB][FloatingActionButtonSize.Regular] with [smaller FABs][FloatingActionButtonSize.Small].
 *
 * Floating action buttons should persist on the screen when content is scrolling.
 * They are attached to the screen itself, not to the surface.
 *
 * When navigating to another destination that also has a FAB, including when navigating between
 * tabs that have a similar FAB, it should briefly disappear and reappear.
 * This shows that the FAB is not connected to any particular tab or destination.
 *
 * The lower right corner is the best place for a FAB on a mobile screen.
 * On a large screen, consider placing the FAB in the upper left region.
 *
 * Multiple sizes are available, see [FloatingActionButtonSize].
 * The color theme is configurable, see [FloatingActionButtonTheme].
 *
 * ### External resources
 *
 * [Material3 Specs](https://m3.material.io/components/floating-action-button/overview).
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun FloatingActionButton(
	action: () -> Unit,
	tooltip: String? = null,
	progress: Progress = done(),
	theme: FloatingActionButtonTheme = FloatingActionButtonTheme.PrimaryColor,
	size: FloatingActionButtonSize = FloatingActionButtonSize.Regular,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
	icon: @Composable () -> Unit,
) {
	Button({
		tooltip?.let(::title)
		onClick { action() }

		when (theme) {
			FloatingActionButtonTheme.PrimaryColor -> classes("bg-primary-container", "text-primary-container-on")
			FloatingActionButtonTheme.SecondaryColor -> classes("bg-secondary-container", "text-secondary-container-on")
			FloatingActionButtonTheme.TertiaryColor -> classes("bg-tertiary-container", "text-tertiary-container-on")
			FloatingActionButtonTheme.SurfaceColor -> classes("bg-surface-container", "text-surface-container-on")
		}

		when (size) {
			FloatingActionButtonSize.Regular -> classes("p-2")
			FloatingActionButtonSize.Small -> classes("p-1")
			FloatingActionButtonSize.Large -> classes("text-xl", "p-4")
		}

		attrs()
	}) {
		if (progress != done()) {
			CircularProgressIndicator(progress)
		} else {
			icon()
		}
	}
}

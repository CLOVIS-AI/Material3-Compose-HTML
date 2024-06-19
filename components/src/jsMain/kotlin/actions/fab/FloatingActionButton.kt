package opensavvy.material3.tailwind.actions.fab

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import opensavvy.material3.tailwind.actions.fab.FloatingActionButtonSize.*
import opensavvy.material3.tailwind.actions.fab.FloatingActionButtonTheme.*
import opensavvy.material3.tailwind.communication.progress.CircularProgressIndicator
import opensavvy.progress.Progress
import opensavvy.progress.done
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text
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
 * ### Extended FAB
 *
 * The extended floating action button is a variant of the FAB, which has a [label] in addition to the icon.
 * It is recommended to use for the single most useful action on a screen.
 *
 * This component automatically switches to the extended variant if [label] is provided.
 * You can also use [showLabel] and [showIcon] to more easily control which components are displayed.
 * Avoid the extended variants with sizes other than [Regular][FloatingActionButtonSize.Regular].
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
	label: String? = null,
	tooltip: String? = null,
	progress: Progress = done(),
	showLabel: Boolean = true,
	showIcon: Boolean = true,
	theme: FloatingActionButtonTheme = PrimaryColor,
	size: FloatingActionButtonSize = Regular,
	attrs: AttrsScope<HTMLButtonElement>.() -> Unit = {},
	icon: @Composable () -> Unit,
) {
	Button({
		tooltip?.let(::title)
		onClick { action() }

		classes(
			"mdk-fab",
			when (theme) {
				PrimaryColor -> "mdk-fab-color-primary"
				SecondaryColor -> "mdk-fab-color-secondary"
				TertiaryColor -> "mdk-fab-color-tertiary"
				SurfaceColor -> "mdk-fab-color-surface"
			},
			when (size) {
				Regular -> "mdk-fab-regular"
				Small -> "mdk-fab-small"
				Large -> "mdk-fab-large"
			}
		)

		attrs()
	}) {
		if (progress != done()) {
			CircularProgressIndicator(progress)
		} else if (showIcon) {
			icon()
		}

		if (label != null && showLabel)
			Text(label)
	}
}

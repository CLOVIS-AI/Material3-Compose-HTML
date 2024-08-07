package opensavvy.material3.html.communication.snackbar

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import opensavvy.material3.html.ExperimentalComponent
import opensavvy.material3.html.UnfinishedComponent
import opensavvy.material3.html.actions.buttons.ButtonGroup
import opensavvy.material3.html.actions.buttons.TextButton
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

private val snackbarCompositionLocal = compositionLocalOf<MutableList<Snackbar>> {
	error("rememberSnackbarCreator() should only be called when a SnackbarHost is present in the hierarchy.")
}

/**
 * Enables the use of snackbars.
 *
 * Within [block], the [rememberSnackbarCreator] function can be called to create a new snackbar.
 *
 * [rememberSnackbarCreator] always creates a snackbar in the first [SnackbarHost] that appears as its parent.
 * Usually, [SnackbarHost] is called near the root of the screen, but multiple snackbar hosts could be added to the same
 * screen.
 */
@UnfinishedComponent
@ExperimentalComponent
@Composable
fun SnackbarHost(block: @Composable () -> Unit) {
	val bars = remember { mutableStateListOf<Snackbar>() }

	Div({
		classes("mdk-snackbar-host")
	}) {
		CompositionLocalProvider(snackbarCompositionLocal provides bars) {
			Div {
				block()
			}

			Snackbar(bars.firstOrNull()) {
				bars.remove(it)
			}
		}
	}
}

/**
 * Allows to obtain a [SnackbarCreator] instance, on which [create][SnackbarCreator.create] can be used to create
 * a new snackbar.
 *
 * To learn more about snackbars and when to use them, see [SnackbarCreator.create].
 *
 * ```kotlin
 * @Composable
 * fun DisplayUser(user: User, saveUser: suspend (User) -> Unit) {
 *     val snackbarCreator = rememberSnackbarCreator()
 *     val coroutineScope = rememberCoroutineScope()
 *
 *     Text("Name: ${user.name}")
 *     Text("Age: ${user.age}")
 *
 *     TextButton(
 *         "Save",
 *         action = {
 *             coroutineScope.launch {
 *                 saveUser(user)
 *                 snackbarCreator.create("Saved")
 *             }
 *         }
 *     )
 * }
 * ```
 *
 * To be able to call this function, [SnackbarHost] must have been called somewhere in the component's hierarchy.
 * [SnackbarHost] is responsible for actually displaying the snackbar.
 */
@Composable
fun rememberSnackbarCreator(): SnackbarCreator {
	val snackbarCompositionLocal = snackbarCompositionLocal.current
	return remember { SnackbarCreator(snackbarCompositionLocal) }
}

@UnfinishedComponent
@ExperimentalComponent
@Composable
private fun Snackbar(bar: Snackbar?, dismiss: (Snackbar) -> Unit) {
	var displayedBar by remember { mutableStateOf<Snackbar?>(null) }
	var opacity by remember { mutableStateOf(0f) }

	// Animate the opacity when the bar changes
	LaunchedEffect(bar) {
		when {
			bar == null -> {
				// The snackbar has just disappeared. Make it invisible, and then remove it.
				opacity = 0f
				delay(300)
				displayedBar = null
			}

			displayedBar == null -> {
				// There is a new snackbar to display, and we're not currently displaying one.
				opacity = 1f
				displayedBar = bar
			}

			bar == displayedBar -> {
				// The bar has changed, but we're already displaying it. Nothing to do.
			}

			else -> {
				// The bar has changed, but we're already displaying another one.
				// Immediately skip to the new one.
				opacity = 1f
				displayedBar = bar
			}
		}
	}

	// Automatically dismiss the bar after some time
	LaunchedEffect(bar) {
		if (bar != null && bar.autoDismiss) {
			delay(3000)
			dismiss(bar)
		}
	}

	Div({
		classes("mdk-snackbar")

		style {
			variable("--mdk-snackbar-opacity", opacity)
		}
	}) {
		val displayed = displayedBar ?: return@Div

		P { Text(displayed.text) }

		ButtonGroup {
			for (action in displayed.actions.reversed()) {
				TextButton(action.label, action.onClick)
			}

			if (!displayed.autoDismiss)
				TextButton("×", { dismiss(displayed) })
		}
	}
}

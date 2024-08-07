package opensavvy.material3.html.communication.snackbar

/**
 * Snackbar declaration center.
 *
 * To learn more about this class, see [rememberSnackbarCreator].
 */
class SnackbarCreator internal constructor(
	private val snackbar: MutableList<Snackbar>
) {

	/**
	 * Creates a snackbar.
	 *
	 * ### Usage
	 *
	 * Snackbars inform users of a process that an app has performed or will perform.
	 * They appear temporarily, towards the bottom of the screen.
	 * They shouldn't interrupt the user experience, and they don't require user input to disappear.
	 *
	 * For example, a snackbar could be used to signify that an action has been performed:
	 * ```kotlin
	 * snackbarCreator.create("All changes saved")
	 * ```
	 *
	 * ### Actions
	 *
	 * A snackbar may display one or more [actions] to the user.
	 * Displaying more than one action is not recommended.
	 *
	 * A common use case is to allow the user to undo the action they just did:
	 * ```kotlin
	 * snackbarCreator.create(
	 *     "All changes saved",
	 *     "Undo" to { undoThisOperation() }
	 * )
	 * ```
	 *
	 * If multiple actions are declared, the most important one should be declared first.
	 *
	 * ### Dismiss behavior
	 *
	 * By default, the snackbar will disappear automatically after a few seconds.
	 *
	 * To keep the snackbar visible until the user has interacted with it, set [autoDismiss] to `true`.
	 * In that case, an additional action will automatically be added to allow the user to dismiss it.
	 *
	 * ### External resources
	 *
	 * [Material3 Specs](https://m3.material.io/components/snackbar).
	 *
	 * @param text Main text displayed to the user. Avoid more than two lines of text.
	 */
	fun create(
		text: String,
		vararg actions: Pair<String, () -> Unit>,
		autoDismiss: Boolean = false,
	) {
		snackbar += Snackbar(text, actions.map { SnackbarAction(it.first, it.second) }, autoDismiss)
	}
}

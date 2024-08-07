package opensavvy.material3.html.communication.snackbar

internal class Snackbar(
	val text: String,
	val actions: List<SnackbarAction>,
	val autoDismiss: Boolean,
)

internal class SnackbarAction(
	val label: String,
	val onClick: () -> Unit,
)

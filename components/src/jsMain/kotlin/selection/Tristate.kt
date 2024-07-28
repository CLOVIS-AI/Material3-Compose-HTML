package opensavvy.material3.html.selection

/**
 * A simple tristate: [Active], [Inactive] or [Indeterminate].
 */
sealed interface Tristate {
	/**
	 * Components that accept a [Tristate] as input rarely emit the [Indeterminate] value:
	 * users usually cannot usually directly cause the indeterminate state to occur.
	 */
	sealed interface Output : Tristate

	data object Active : Tristate, Output
	data object Inactive : Tristate, Output
	data object Indeterminate : Tristate
}

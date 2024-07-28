package opensavvy.material3.html.actions.fab

/**
 * The available [FloatingActionButton] sizes.
 */
enum class FloatingActionButtonSize {
	/**
	 * The default size.
	 */
	Regular,

	/**
	 * A smaller size, used for secondary, supporting actions.
	 * One or more small FABs can be paired with a [Regular] or extended FAB.
	 *
	 * It is also possible to use small FABs in place of the [Regular] size when the screen is small.
	 */
	Small,

	/**
	 * A larger size, useful when the layout calls for a clear and prominent primary action,
	 * and where a larger footprint would help the user engage.
	 * For example, when appearing in a medium window size.
	 *
	 * Don't use a large FAB if its bigger size obscures important information on the screen.
	 */
	Large,
}

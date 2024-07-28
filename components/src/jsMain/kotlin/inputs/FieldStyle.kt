package opensavvy.material3.html.inputs

/**
 * The different visual styles for input fields.
 *
 * Avoid using multiple styles in the same region of a screen.
 */
enum class FieldStyle {
	/**
	 * Outlined fields have less visual emphasis than [Filled] fields.
	 *
	 * When they appear in places like forms (where many text fields are placed together),
	 * their reduced emphasis helps simplify the layout.
	 */
	Outlined,

	/**
	 * Filled fields have more visual emphasis than [Outlined] fields.
	 *
	 * Filled fields have a background color, and are thus more suited to pages
	 * where the existing background could make the text harder to read.
	 */
	Filled,

	@Suppress("unused")
	@Deprecated("Additional field styles may be added in the future, please always handle the case where an unknown style is passed.", level = DeprecationLevel.ERROR)
	NonExhaustive,
}

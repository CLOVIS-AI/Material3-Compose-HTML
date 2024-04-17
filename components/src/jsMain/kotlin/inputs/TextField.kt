package opensavvy.material3.tailwind.inputs

import androidx.compose.runtime.Composable
import opensavvy.material3.tailwind.ExperimentalComponent
import opensavvy.material3.tailwind.UnfinishedComponent
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput

/**
 * A text field.
 *
 * ### Usage
 *
 * Use a text field when someone needs to enter text into a UI,
 * such as filling in contact or payment information.
 *
 * ### External resources
 *
 * - [Material3 Spec](https://m3.material.io/components/text-fields).
 */
@ExperimentalComponent
@UnfinishedComponent
@Composable
fun TextField(
	label: String,
	text: String?,
	onChange: (String?) -> Unit,
	supportingText: String? = null,
	errorText: String? = null,
	style: FieldStyle = FieldStyle.Outlined,
	leadingIcon: (@Composable () -> Unit)? = null,
	trailingIcon: (@Composable () -> Unit)? = null,
) {
	Label(attrs = {
		classes(
			"mdk-field",
			if (style == FieldStyle.Outlined) "mdk-field-outlined" else "mdk-field-filled"
		)
	}) {
		Text(label)

		Div({
			classes("flex", "gap-2")
		}) {
			leadingIcon?.invoke()

			TextInput(text ?: "") {
				this.onInput { onChange(it.value.takeIf(String::isNotBlank)) }

				classes("outline-none")
			}

			trailingIcon?.invoke()
		}

		if (errorText != null)
			Text(errorText)
		else if (supportingText != null)
			Text(supportingText)
	}
}

package opensavvy.material3.tailwind.demo.utils

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import opensavvy.material3.html.actions.chips.AssistChip
import opensavvy.material3.html.actions.chips.ChipGroup
import opensavvy.material3.html.actions.chips.FilterChip
import opensavvy.material3.html.actions.fab.FloatingActionButtonSize
import opensavvy.material3.html.inputs.FieldStyle
import opensavvy.material3.html.selection.Checkbox
import opensavvy.progress.Progress
import opensavvy.progress.done
import opensavvy.progress.loading
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import kotlin.enums.EnumEntries
import kotlin.reflect.KClass

class Parameters(
	private val coroutineScope: CoroutineScope,
) {
	private var parameters = mutableStateMapOf<String, Parameter<*>>()

	@Composable
	fun <T: Any> getWithType(name: String, defaultValue: T, type: KClass<T>): T {
		val parameter = remember(name) {
			parameters.getOrPut(name) {
				Parameter(name, mutableStateOf(defaultValue), type, coroutineScope)
			}
		}

		@Suppress("UNCHECKED_CAST")
		return parameter.state as T
	}

	@Composable
	fun draw() {
		P({
			style {
				marginTop(0.5.cssRem)
				marginBottom(0.5.cssRem)
			}
		}) {
			Text("States:")
		}

		Div({
			style {
				marginLeft(0.5.cssRem)
			}
		}) {
			for (parameter in parameters.values)
				parameter.draw()
		}
	}
}

@Composable
fun rememberParameters(): Parameters {
	val scope = rememberCoroutineScope()
	return remember { Parameters(scope) }
}

// region Helpers

@Composable
inline fun <reified T : Any> Parameters.named(name: String, defaultValue: T): T =
	getWithType(name, defaultValue, T::class)

@Composable
fun Parameters.progress(): Progress =
	named<Progress>("Progress", done())

// endregion
// region Rendering

private class Parameter<T: Any>(
	val name: String,
	mutableState: MutableState<T>,
	val type: KClass<T>,
	val scope: CoroutineScope,
) {

	var state by mutableState

	@Suppress("UNCHECKED_CAST")
	@Composable
	fun draw() = Label(attrs = {
		style {
			display(DisplayStyle.Flex)
			gap(1.5.px)
		}
	}) {
		Text("$name: ")

		when (type) {
			String::class -> Input(InputType.Text) {
				value(state as String)
				onInput { state = it.value as T }
			}
			Boolean::class -> Checkbox(state as Boolean, { state = it as T })
			Progress::class -> {
				Text(state.toString())
				ChipGroup {
					AssistChip("Done", onClick = { state = done() as T })
					AssistChip("Indeterminate", onClick = { state = loading() as T })
					AssistChip("33%", onClick = { state = loading(0.33) as T })
					AssistChip("Launch", onClick = {
						scope.launch {
							repeat(100) {
								state = loading(0.01 * it) as T
								delay(50)
							}
							state = done() as T
						}
					})
				}
			}
			FloatingActionButtonSize::class -> drawEnum(FloatingActionButtonSize.entries)
			FieldStyle::class -> drawEnum(FieldStyle.entries)
			else -> Text("Unsupported parameter type: $type")
		}
	}

	@Suppress("UNCHECKED_CAST")
	@Composable
	private fun drawEnum(entries: EnumEntries<*>) {
		ChipGroup {
			for (entry in entries) {
				FilterChip(entry.name, entry == state, onToggle = { state = entry as T })
			}
		}
	}
}

// endregion

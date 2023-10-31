package opensavvy.material3.tailwind.demo.utils

import androidx.compose.runtime.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import opensavvy.material3.tailwind.actions.buttons.TextButton
import opensavvy.progress.Progress
import opensavvy.progress.done
import opensavvy.progress.loading
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.dom.*
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
			classes("my-2")
		}) {
			Text("States:")
		}

		for (parameter in parameters.values)
			parameter.draw()
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
		classes("block")
	}) {
		Text("$name: ")

		when (type) {
			String::class -> Input(InputType.Text) {
				value(state as String)
				onInput { state = it.value as T }
			}
			Boolean::class -> CheckboxInput(state as Boolean) {
				onInput { state = it.value as T }
			}
			Progress::class -> {
				Text(state.toString())
				TextButton("Set to done", action = { state = done() as T })
				TextButton("Set to 33%", action = { state = loading(0.33) as T })
				TextButton("Launch", action = {
					scope.launch {
						repeat(100) {
							state = loading(0.01 * it) as T
							delay(50)
						}
						state = done() as T
					}
				})
			}
			else -> Text("Unsupported parameter type: $type")
		}
	}
}

// endregion
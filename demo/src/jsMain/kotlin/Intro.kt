package opensavvy.material3.demo

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Article
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun Intro() = Article {
	P {
		A("https://m3.material.io/") { Text("Material3") }
		Text(" is the latest iteration of Google's Material Design system.")

		Text(" Originally designed for Android, it is characterized by large colorful areas to facilitate touchscreen usage, and the liberal use of motion to create an organic feeling.")
	}

	P {
		Text("This page is a demonstration of the ")
		A("https://gitlab.com/opensavvy/ui/compose-material3-html") { Text("OpenSavvy implementation") }
		Text(" of Material3.")
	}

	P {
		Text("Jetpack Compose is a UI toolkit for Kotlin and Android, created by Google, and inspired by React.")
		Text(" Compose takes advantage of the Kotlin compiler to implement features that could not be with JavaScript.")
		Text(" This page is running under Compose HTML, a port of Compose that uses the elements of the DOM directly.")
		Text(" This page is also available in ")
		A("https://gitlab.com/opensavvy/ui/compose-material3-html/-/tree/main/demo/src/jsMain/kotlin") { Text("source code") }
		Text(".")
	}

	P {
		Text("Unlike other technologies like Compose for Web or Flutter, which are based on the canvas, this page is a true website in the traditional sense of the term:")
		Text(" all styling is done via CSS, and it is compatible with development and accessibility tools.")
	}
}

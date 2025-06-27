plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.library)
	alias(libsCommon.plugins.compose.multiplatform)
	alias(libsCommon.plugins.compose.compiler)

	alias(libs.plugins.resources.producer)
}

kotlin {
	js(IR) {
		browser()
	}

	sourceSets.jsMain {
		dependencies {
			api(projects.theme)
			api(compose.runtime)
			api(compose.html.core)
			implementation(compose.html.svg)

			api(libs.kotlinx.coroutines)
			api(libs.pedestal.progress)
		}

		resources.srcDir(file("src/jsMain/kotlin"))
		resources.exclude("**/*.kt")
	}
}

library {
	name.set("Material3 Components")
	description.set("Implementation of the Material3 UI components")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-html")

	license.set {
		name.set("Apache 2.0")
		url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
	}
}

plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.library)
	alias(opensavvyConventions.plugins.aligned.composeMultiplatform)

	alias(libs.plugins.resources.producer)
}

kotlin {
	js(IR) {
		browser()
	}

	val jsMain by sourceSets.getting {
		dependencies {
			api(compose.runtime)
			api(compose.html.core)
		}
	}
}

library {
	name.set("Material3 Colors and themes for Kotlin JS")
	description.set("Expose the Material3 color theme to Kotlin/JS projects")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-html")

	license.set {
		name.set("Apache 2.0")
		url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
	}
}

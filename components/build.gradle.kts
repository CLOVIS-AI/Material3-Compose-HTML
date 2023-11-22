plugins {
	alias(opensavvyConventions.plugins.kotlin.library)
	alias(opensavvyConventions.plugins.aligned.composeMultiplatform)
}

kotlin {
	js(IR) {
		browser()
	}

	val jsMain by sourceSets.getting {
		dependencies {
			api(projects.tailwindcss)
			api(compose.runtime)
			api(compose.html.core)
			implementation(compose.html.svg)

			api(libs.pedestal.progress)
		}
	}
}

library {
	name.set("Material3 Components")
	description.set("Implementation of the Material3 UI components")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-tailwind")

	license.set {
		name.set("Apache 2.0")
		url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
	}
}

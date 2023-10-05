plugins {
	id("conventions.base")
	id("conventions.kotlin")
	id("conventions.library")

	alias(libs.plugins.compose)
}

kotlin {
	js(IR) {
		browser()
	}

	val jsMain by sourceSets.getting {
		dependencies {
			api(compose.runtime)
			api(compose.html.core)

			api(projects.components.componentUtilities)
		}
	}
}

library {
	name.set("Material3 Action components for Compose HTML")
	description.set("Action components help people achieve an aim")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-tailwind")
}

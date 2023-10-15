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
			api(projects.components.componentUtilities)
		}
	}
}

library {
	name.set("Material3 Communication")
	description.set("Communication components provide useful information")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-tailwind")
}

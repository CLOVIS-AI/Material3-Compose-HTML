plugins {
	id("conventions.base")
	id("conventions.kotlin")
	id("conventions.library")
}

kotlin {
	js(IR) {
		browser()
	}

	val jsMain by sourceSets.getting {
		dependencies {
			api(libs.pedestal.progress)
		}
	}
}

library {
	name.set("Material3 Utils")
	description.set("Common utilities for all Material3 components")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-tailwind")
}

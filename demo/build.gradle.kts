plugins {
	id("conventions.base")
	id("conventions.kotlin")
}

kotlin {
	js(IR) {
		browser()

		binaries.executable()
	}

	val jsMain by sourceSets.getting {
		dependencies {
			implementation(projects.components.actions)
		}
	}
}

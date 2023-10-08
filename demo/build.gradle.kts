plugins {
	id("conventions.base")
	id("conventions.kotlin")

	alias(libs.plugins.compose)
	alias(libs.plugins.vite)
}

kotlin {
	js(IR) {
		browser()

		binaries.executable()
	}

	sourceSets.all {
		languageSettings.optIn("opensavvy.material3.tailwind.ExperimentalComponent")
		languageSettings.optIn("opensavvy.material3.tailwind.UnfinishedComponent")
	}

	val jsMain by sourceSets.getting {
		dependencies {
			implementation(projects.components.actions)
		}
	}
}

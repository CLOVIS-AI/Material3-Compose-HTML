plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.application)
	alias(opensavvyConventions.plugins.aligned.composeMultiplatform)

	alias(libs.plugins.vite)
	alias(libs.plugins.resources.consumer)
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
			implementation(projects.components)
		}
	}
}

dependencies {
	transitiveJsResources(projects.theme)
	transitiveJsResources(projects.components)
}

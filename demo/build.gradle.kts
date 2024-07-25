plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.application)
	alias(opensavvyConventions.plugins.aligned.composeMultiplatform)
	alias(opensavvyConventions.plugins.aligned.composeCompiler)

	alias(libs.plugins.vite)
	alias(libs.plugins.resources.consumer)
}

kotlin {
	js(IR) {
		browser()

		binaries.executable()
	}

	sourceSets.all {
		languageSettings.optIn("opensavvy.material3.html.ExperimentalComponent")
		languageSettings.optIn("opensavvy.material3.html.UnfinishedComponent")
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

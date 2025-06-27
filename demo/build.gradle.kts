plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.application)
	alias(libsCommon.plugins.compose.multiplatform)
	alias(libsCommon.plugins.compose.compiler)
	alias(libsCommon.plugins.kotlinx.serialization)

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
			implementation(projects.themeDynamic)
			implementation(libs.kotlinx.serialization)
		}
	}
}

dependencies {
	transitiveJsResources(projects.theme)
	transitiveJsResources(projects.components)
}

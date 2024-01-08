plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.application)
	alias(opensavvyConventions.plugins.aligned.composeMultiplatform)

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
			implementation(projects.components)

			implementation(devNpm("postcss", libs.versions.postcss.get()))
			implementation(devNpm("autoprefixer", libs.versions.autoprefixer.get()))
		}
	}
}

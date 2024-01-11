plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.library)
	alias(opensavvyConventions.plugins.aligned.composeMultiplatform)

	alias(libs.plugins.resources.producer)
}

kotlin {
	js(IR) {
		browser()
	}

	val jsMain by sourceSets.getting {
		dependencies {
			api(compose.runtime)
			api(compose.html.core)

			api(npm("tailwindcss", libs.versions.tailwindcss.get()))
		}
	}
}

library {
	name.set("TailwindCSS for Kotlin")
	description.set("Default TailwindCSS configuration for Kotlin")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-tailwind")

	license.set {
		name.set("Apache 2.0")
		url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
	}
}

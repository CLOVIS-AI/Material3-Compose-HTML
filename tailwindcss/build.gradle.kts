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
			api(npm("tailwindcss", libs.versions.tailwindcss.get()))
		}
	}
}

library {
	name.set("TailwindCSS for Kotlin")
	description.set("Default TailwindCSS configuration for Kotlin")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-tailwind")
}

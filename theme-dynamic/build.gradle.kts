plugins {
	alias(opensavvyConventions.plugins.base)
	alias(opensavvyConventions.plugins.kotlin.library)
	alias(libsCommon.plugins.compose.multiplatform)
	alias(libsCommon.plugins.compose.compiler)
}

kotlin {
	js(IR) {
		browser()
	}

	val jsMain by sourceSets.getting {
		dependencies {
			api(projects.theme)
			api(libs.material.colors)
		}
	}
}

library {
	name.set("Material You dynamic colors for Kotlin JS")
	description.set("Import a Material You color scheme to Kotlin/JS projects")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-html")

	license.set {
		name.set("Apache 2.0")
		url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
	}
}

plugins {
	id("conventions.base")
	id("conventions.kotlin")
	id("conventions.library")
}

kotlin {
	js(IR) {
		browser()
	}
}

library {
	name.set("Common utilities for all Material3 components")
	description.set("Common utilities for all Material3 components")
	homeUrl.set("https://gitlab.com/opensavvy/ui/compose-material3-tailwind")
}

plugins {
	id("conventions.base")
	id("conventions.kotlin")
}

kotlin {
	js(IR) {
		browser()

		binaries.executable()
	}
}

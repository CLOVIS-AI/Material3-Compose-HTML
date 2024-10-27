# Module Material3 Colors and themes for Kotlin JS

CSS utilities to declare color themes, etc.

<a href="https://search.maven.org/search?q=dev.opensavvy.material3.html.theme"><img src="https://img.shields.io/maven-central/v/dev.opensavvy.material3.html/theme.svg?label=Maven%20Central"></a>
<a href="https://opensavvy.dev/open-source/stability.html"><img src="https://badgen.net/static/Stability/alpha/purple"></a>
<a href="https://javadoc.io/doc/dev.opensavvy.material3.html/theme"><img src="https://badgen.net/static/Other%20versions/javadoc.io/blue"></a>

## Design tokens

Material3 is defined in term of design tokens: pre-defined values that each app can change to configure its design as a whole. Currently, this library supports color design tokens only ("Material You").

Currently, all shades of a palette have to be passed to the library (see [InstallColorScheme][opensavvy.material3.css.InstallColorScheme]).
To be able to generate all shades from the three main colors, we would need a Kotlin Multiplatform port [material-color-utilities](https://github.com/material-foundation/material-color-utilities). If you are currently searching for a project to start, please do get in touch!

## Using this module

This module contains the TailwindCSS configuration to expose these design tokens, as well as a few Kotlin helpers to control them.
However, [Kotlin doesn't currently import configuration files from dependencies](https://youtrack.jetbrains.com/issue/KT-38230).
Until this is fixed, we created a [custom Gradle plugin](https://gitlab.com/opensavvy/automation/kotlin-js-resources) to do it for us.

The Kotlin code from this module can be imported into your project like any other library (if you already depend on another module of this project, like the Components module, it is unnecessary to add a dependency on this module).
However, the configuration files require more setup; they are necessary even if you import another module from this project.

### With the Gradle plugin

Add the following to your build script:

```kotlin
plugins {
	kotlin("multiplatform") version "add the version here"
	id("dev.opensavvy.resources.consumer") version "add the version here"
}

kotlin {
	js {
		// …
	}

	sourceSets.jsMain {
		// This is not necessary if you already have a dependency on another module from this project
		dependencies("dev.opensavvy.material3.tailwind:tailwindcss:<add the version here>")
	}
}

dependencies {
	// Adds the configuration files to your project
	// Make sure the version number follows the rest of the project
	transitiveJsResources("dev.opensavvy.material3.tailwind:tailwindcss:<add the version here>")
}
```

To learn more about the Gradle plugin, see [its documentation](https://opensavvy.gitlab.io/automation/kotlin-js-resources/api-docs/).

Edit your main CSS file by adding:

```css
@import "imported/mdk.css";
```

Don't forget to call [InstallColorScheme][opensavvy.material3.css.InstallColorScheme] at the composable root to select the color scheme.

### Without the Gradle plugin

We do not recommend this solution, because each time you update this library, you will be required to manually update the configuration files you import from the library. If you use a build system that doesn't recognize [Gradle module metadata](https://docs.gradle.org/current/userguide/publishing_gradle_module_metadata.html), you do not have any other options.

To put simply, this solution is [to copy the configuration files](https://gitlab.com/opensavvy/ui/compose-material3-html/-/tree/main/theme/src/jsMain/resources) into your own project.

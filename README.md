# Material3 for Compose HTML

Blackbox implementation of the [Material3](https://m3.material.io/) specification for [Compose HTML](https://github.com/JetBrains/compose-multiplatform#compose-html).

> This library is currently at early stages of development.
>
> If you have CSS skills, or want to learn, please consider [contributing](CONTRIBUTING.md).

Useful links:

- [Documentation](https://opensavvy.gitlab.io/ui/compose-material3-html/api-docs/index.html)
- [Demo app source code](demo) | [Deployed version](https://opensavvy.gitlab.io/ui/compose-material3-html/demo/index.html)

## Why?

The [official Material3 library](https://github.com/material-components/material-web) is not made for Compose HTML, lacks many animations, and is [not maintained anymore](https://github.com/material-components/material-web/discussions/5642).

We decided to create our own alternative implementation that is custom-built for Kotlin.

## Design tokens

This library implements all Material3 color [design tokens](https://m3.material.io/foundations/design-tokens/overview) as CSS variables, making them easy to use inside components.

To import them in your project, see [the documentation](https://opensavvy.gitlab.io/ui/compose-material3-html/api-docs/theme/index.html).

## Component list

This is the full component list as specified in the [Material3 specification](https://m3.material.io/components).
When components are unfinished, their tracking issues are linked.
To learn more, see [the documentation](https://opensavvy.gitlab.io/ui/compose-material3-html/api-docs/components/index.html).

Actions:

- Common buttons: #15
- Floating action buttons: #19
- Extended FAB: #17
- Icon buttons: #20, #21
- Segmented buttons: #22, #23

Communication:

- Badges: #25
- Linear progress indicator
- Circular progress indicator: #87, #89
- Snackbar: #29
- Tooltips: #44, #45

Containment:

- Bottom sheets: #30, #31
- Cards: #33
- Carousel: #34, #35
- Dialogs: #36, #37
- Divider
- Lists: #40, #41
- Side sheets: #42, #43

Navigation:

- Bottom app bar: #46, #47
- Navigation bar: #48, #49
- Navigation drawer: #50, #51
- Navigation rail: #52, #53
- Search: #54, #55
- Tabs: #56, #57
- Top app bar: #58, #59

Selection:

- Checkbox: #61
- Chips: #63
- Date pickers: #64, #65
- Menus: #66, #67
- Radio button: #68, #69
- Sliders: #70, #71
- Switch: #73
- Time pickers: #74, #75

Text inputs:

- Text fields: #76, #77

## License

This project is licensed under the [Apache 2.0 license](LICENSE).

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md).
- To learn more about our coding conventions and workflow, see the [OpenSavvy website](https://opensavvy.dev/open-source/index.html).
- This project is based on the [OpenSavvy Playground](docs/playground/README.md), a collection of preconfigured project templates.

If you don't want to clone this project on your machine, it is also available using [GitPod](https://www.gitpod.io/) and [DevContainer](https://containers.dev/) ([VS Code](https://code.visualstudio.com/docs/devcontainers/containers) • [IntelliJ & JetBrains IDEs](https://www.jetbrains.com/help/idea/connect-to-devcontainer.html)). Don't hesitate to create issues if you have problems getting the project up and running.

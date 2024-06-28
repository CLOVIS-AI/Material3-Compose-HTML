# Module Material3 Components

Compose for HTML implementation of the Material3 components, using TailwindCSS.

<a href="https://search.maven.org/search?q=dev.opensavvy.material3.tailwind.components"><img src="https://img.shields.io/maven-central/v/dev.opensavvy.material3.tailwind/components.svg?label=Maven%20Central"></a>

# Package opensavvy.material3.tailwind

Classes and tools common to all components.

# Package opensavvy.material3.tailwind.actions.buttons

Static and predetermined actions, offering a linear step in a flow.

Buttons are categorized by their importance:
- [TextButton][opensavvy.material3.tailwind.actions.buttons.TextButton] is used for regular actions.
- [OutlinedButton][opensavvy.material3.tailwind.actions.buttons.OutlinedButton] is used for medium-emphasis actions.
- [FilledButton][opensavvy.material3.tailwind.actions.buttons.FilledButton] is used for the singular most important action on a screen.
- [FilledTonalButton][opensavvy.material3.tailwind.actions.buttons.FilledTonalButton] is used for the most important actions on a screen, except for the most important one.

Sometimes, we need other specific button types:
- [ElevatedButton][opensavvy.material3.tailwind.actions.buttons.ElevatedButton] is used on top of patterned backgrounds, where a regular button would be too hard to read.

Other useful components:
- [ButtonGroup][opensavvy.material3.tailwind.actions.buttons.ButtonGroup] is a simple horizontal layout to correctly space multiple buttons acting in a single group.

# Package opensavvy.material3.tailwind.actions.chips

Reactive and contextual actions, impacting either the current screen or another app entirely.

Chips are often used in groups of multiple chips acting together.

Chips that have an impact in the current view:
- [FilterChip][opensavvy.material3.tailwind.actions.chips.FilterChip] is a filter that is always present, that can be active or not.
- [InputChip][opensavvy.material3.tailwind.actions.chips.InputChip] is a filter created by the user, which they may delete.

Chips that have an impact somewhere else:
- [AssistChip][opensavvy.material3.tailwind.actions.chips.AssistChip] is an action that can span multiple apps, for example opening another app.
- [SuggestionChip][opensavvy.material3.tailwind.actions.chips.SuggestionChip] is a dynamically-generated action based on the contents of the current view.

Other useful components:
- [ChipGroup][opensavvy.material3.tailwind.actions.chips.ChipGroup] is a simple horizontal layout to correctly space multiple chips acting in a single group.

# Package opensavvy.material3.tailwind.actions.fab

Floating Action Buttons (FABs) are large buttons that let the user trigger the main action on a screen.

# Package opensavvy.material3.tailwind.communication.progress

Indicators to communicate the progress of an ongoing operation to the user.

# Package opensavvy.material3.tailwind.containment.card

Group related information into a cohesive unit.

# Package opensavvy.material3.tailwind.containment.dividers

Thin lines that group content in lists or other containers.

- [Divider][opensavvy.material3.tailwind.containment.dividers.Divider] visually groups components and creates hierarchy.
- [InsetDivider][opensavvy.material3.tailwind.containment.dividers.InsetDivider] separate related content within a section.

# Package opensavvy.material3.tailwind.selection

Selection components let people specify choices.

- [Switch][opensavvy.material3.tailwind.selection.Switch] toggles the selection of an item on or off, for example settings.
- [Checkbox][opensavvy.material3.tailwind.selection.Checkbox] toggles the selection of multiple related items on or off.

# Package opensavvy.material3.tailwind.inputs

Inputs allow users to enter some information.

- [TextField][opensavvy.material3.tailwind.inputs.TextField] allows entering text.

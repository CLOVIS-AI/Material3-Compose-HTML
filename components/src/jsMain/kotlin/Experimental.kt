package opensavvy.material3.html

/**
 * Marks a component as experimental.
 *
 * It may be deleted at any time, or its signature may change at any time.
 */
@RequiresOptIn("This component is experimental. It may be deleted or modified at any point.")
@MustBeDocumented
annotation class ExperimentalComponent

/**
 * Declares that a component's visual implementation is not finished.
 *
 * By itself, this annotation does not imply that source- or binary-incompatible changes will occur.
 * However, it does imply that major changes to the visual appearance of the component are likely to occur.
 * The presence of this annotation therefore doesn't imply the need to propagate the annotation; you may simply opt in to the current looks if you want.
 *
 * To signify that a component will change in a source- or binary-incompatible manner, use [ExperimentalComponent].
 */
@RequiresOptIn("This component's visual appearance is not yet finished, it may behave weirdly in some edge cases.", RequiresOptIn.Level.WARNING)
@MustBeDocumented
annotation class UnfinishedComponent(
	/**
	 * Link to external issue trackers that refer to planned work on this component.
	 */
	val issues: Array<String> = [],
)

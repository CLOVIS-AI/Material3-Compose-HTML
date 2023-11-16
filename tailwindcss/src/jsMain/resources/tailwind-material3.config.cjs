module.exports = {
	theme: {
		extend: {
			colors: {
				'scrim': 'rgb(var(--md-token-scrim) / <alpha-value>)',
				'shadow': 'rgb(var(--md-token-shadow) / <alpha-value>)',
				'outline': 'rgb(var(--md-token-outline) / <alpha-value>)',
				'outline-variant': 'rgb(var(--md-token-outline-variant) / <alpha-value>)',
				'background': 'rgb(var(--md-token-background) / <alpha-value>)',
				'background-on': 'rgb(var(--md-token-background-on) / <alpha-value>)',

				'primary': {
					DEFAULT: 'rgb(var(--md-token-primary) / <alpha-value>)',
					'container': 'rgb(var(--md-token-primary-container) / <alpha-value>)',
					'on': 'rgb(var(--md-token-primary-on) / <alpha-value>)',
					'container-on': 'rgb(var(--md-token-primary-container-on) / <alpha-value>)',
					'inverse': 'rgb(var(--md-token-primary-inverse) / <alpha-value>)',
					'fixed': 'rgb(var(--md-token-primary-fixed) / <alpha-value>)',
					'fixed-dim': 'rgb(var(--md-token-primary-fixed-dim) / <alpha-value>)',
					'fixed-on': 'rgb(var(--md-token-primary-fixed-on) / <alpha-value>)',
					'fixed-on-variant': 'rgb(var(--md-token-primary-fixed-on-variant) / <alpha-value>)',
				},

				'secondary': {
					DEFAULT: 'rgb(var(--md-token-secondary) / <alpha-value>)',
					'container': 'rgb(var(--md-token-secondary-container) / <alpha-value>)',
					'on': 'rgb(var(--md-token-secondary-on) / <alpha-value>)',
					'container-on': 'rgb(var(--md-token-secondary-container-on) / <alpha-value>)',
					'inverse': 'rgb(var(--md-token-secondary-inverse) / <alpha-value>)',
					'fixed': 'rgb(var(--md-token-secondary-fixed) / <alpha-value>)',
					'fixed-dim': 'rgb(var(--md-token-secondary-fixed-dim) / <alpha-value>)',
					'fixed-on': 'rgb(var(--md-token-secondary-fixed-on) / <alpha-value>)',
					'fixed-on-variant': 'rgb(var(--md-token-secondary-fixed-on-variant) / <alpha-value>)',
				},

				'tertiary': {
					DEFAULT: 'rgb(var(--md-token-tertiary) / <alpha-value>)',
					'container': 'rgb(var(--md-token-tertiary-container) / <alpha-value>)',
					'on': 'rgb(var(--md-token-tertiary-on) / <alpha-value>)',
					'container-on': 'rgb(var(--md-token-tertiary-container-on) / <alpha-value>)',
					'inverse': 'rgb(var(--md-token-tertiary-inverse) / <alpha-value>)',
					'fixed': 'rgb(var(--md-token-tertiary-fixed) / <alpha-value>)',
					'fixed-dim': 'rgb(var(--md-token-tertiary-fixed-dim) / <alpha-value>)',
					'fixed-on': 'rgb(var(--md-token-tertiary-fixed-on) / <alpha-value>)',
					'fixed-on-variant': 'rgb(var(--md-token-tertiary-fixed-on-variant) / <alpha-value>)',
				},

				'error': {
					DEFAULT: 'rgb(var(--md-token-error) / <alpha-value>)',
					'container': 'rgb(var(--md-token-error-container) / <alpha-value>)',
					'on': 'rgb(var(--md-token-error-on) / <alpha-value>)',
					'container-on': 'rgb(var(--md-token-error-container-on) / <alpha-value>)',
				},

				'surface': {
					DEFAULT: 'rgb(var(--md-token-surface) / <alpha-value>)',
					'variant': 'rgb(var(--md-token-surface-variant) / <alpha-value>)',
					'on': 'rgb(var(--md-token-surface-on) / <alpha-value>)',
					'variant-on': 'rgb(var(--md-token-surface-variant-on) / <alpha-value>)',
					'inverse': 'rgb(var(--md-token-surface-inverse) / <alpha-value>)',
					'inverse-on': 'rgb(var(--md-token-surface-inverse-on) / <alpha-value>)',
					'tint': 'rgb(var(--md-token-surface-tint) / <alpha-value>)',
					'dim': 'rgb(var(--md-token-surface-dim) / <alpha-value>)',
					'bright': 'rgb(var(--md-token-surface-bright) / <alpha-value>)',
					'container-lowest': 'rgb(var(--md-token-surface-container-lowest) / <alpha-value>)',
					'container-low': 'rgb(var(--md-token-surface-container-low) / <alpha-value>)',
					'container': 'rgb(var(--md-token-surface-container) / <alpha-value>)',
					'container-high': 'rgb(var(--md-token-surface-container-high) / <alpha-value>)',
					'container-highest': 'rgb(var(--md-token-surface-container-highest) / <alpha-value>)',
				},
			},
			opacity: {
				'normal': '0.05',
				'hover': '0.08',
				'focus': '0.12',
				'disabled': '0.38',
				'disabledBg': '0.12',
				'elevationShadow1': '0.15',
				'elevationShadow2': '0.30'
			},
			boxShadow: {
				'elevation1': '0px 1px 3px 1px rgb(0 0 0 / 0.15), 0px 1px 2px 0px rgb(0 0 0 / 0.3)',
				'elevation2': '0px 2px 6px 2px rgb(0 0 0 / 0.15), 0px 1px 2px 0px rgb(0 0 0 / 0.3)',
			}
		},
	},
	plugins: [],
}

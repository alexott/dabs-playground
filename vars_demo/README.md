# vars_demo

The 'vars_demo' project demonstrates how to use [complex](https://docs.databricks.com/aws/en/dev-tools/bundles/variables#define-a-complex-variable) and [lookup](https://docs.databricks.com/aws/en/dev-tools/bundles/variables#retrieve-an-objects-id-value) variables in Databricks Asset Bundles (DABs.

Variables allow to parametrize a bundle. Variables are referenced using `${var.<variable_name>}` syntax. There are different variable types:

* "Normal variables" - static value, could be defined in command line, env variable, …
* "Lookup variables" - fetch information about existing object (cluster or policy ID by name, etc.). This is very handy when you have an object with the same name deployed in different environments, i.e., cluster policies, notification destinations, etc.
* "Complex variable" - consists of multiple values. I.e., it could be used to define cluster configuration, notifications, etc.

Variables could have a different value in each target, and in combination with `default` value it's possible to implement "conditional" overwrite of some values in defined resources.

This demo shows how to define `webhook_notifications` in jobs such way that Slack notifications are defined only in the `prod` environment.  This is done by defining a complex variable `notification_settings` that has an empty value by default, but we're overwriting it in the `prod` environment by looking up the notification destination with a specific name (defined by the `notification_name` variable). (All code is in the [resources/variables.yml](resources/variables.yml)).

And then we can just use the complex variable in the `webhook_notifications` argument (line 13 in [resources/vars_demo.job.yml](resources/vars_demo.job.yml)):

```yaml
webhook_notifications: ${var.notification_settings}
```

You can check with `databricks bundle validate -t dev --output json` that corresponding argument is empty in the `dev`, but if you run `databricks bundle validate -t prod --output json`, then it will be filled with actual ID of the notification destination.
# dabs-playground

## Different examples around Databricks Automation Bundles (DABs)

- [integration-tests](integration-tests) - DAB example on how to redefine resource on per-target base, emulating wrapping of the code into integration test that has additional tasks.
- [jdemo](jdemo) - DAB example that has both Python wheel and JAR artefacts deployed as job tasks.
- [mlops-statcks-multiphase](mlops-statcks-multiphase) - DAB based on `mlops-stacks` template, but with customization to deploy quality monitoring in a separate "stage".
- [vars_demo](vars_demo) - demonstrates how to use complex and lookup variables in DABs.

## Related projects

- [pydabs-genie-agent-retarget](https://github.com/alexott/pydabs-genie-agent-retarget) - plugin for PyDABs to rewrite Unity Catalog references in Genie Agent (formerly Genie space) definitions when you deploy them with DABs.

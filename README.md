# SyGMa KNIME nodes

The [SyGMa](https://github.com/3D-e-Chem/sygma) [KNIME](https://www.knime.org) nodes for the **Sy**stematic **G**eneration of potential **M**et**a**bolites.

[![Build Status](https://travis-ci.org/3D-e-Chem/knime-sygma.svg?branch=master)](https://travis-ci.org/3D-e-Chem/knime-sygma)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=nl.esciencecenter.e3dchem.sygma%3Anl.esciencecenter.e3dchem.sygma&metric=alert_status)](https://sonarcloud.io/dashboard?id=nl.esciencecenter.e3dchem.sygma%3Anl.esciencecenter.e3dchem.sygma)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=nl.esciencecenter.e3dchem.sygma%3Anl.esciencecenter.e3dchem.sygma&metric=coverage)](https://sonarcloud.io/dashboard?id=nl.esciencecenter.e3dchem.sygma%3Anl.esciencecenter.e3dchem.sygma)
[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.1033753.svg)](https://doi.org/10.5281/zenodo.1033753)

# Installation

Requirements:

* KNIME, https://www.knime.org, version 4.0 or higher
* SyGMa Python library, https://github.com/3D-e-Chem/sygma

Steps to get the SyGMa KNIME nodes inside KNIME:

1. Goto Help > Install new software ... menu
2. Press add button
3. Fill text fields with the `https://3d-e-chem.github.io/updates` update site url.
4. Select --all sites-- in `work with` pulldown
5. Select the node
6. Install software
7. Restart KNIME

# Usage

1. Create a new KNIME workflow.
2. Find node in Node navigator panel.
3. Drag node to workflow canvas.

See example workflow in `examples` folder.

# Build

```
mvn verify
```

An Eclipse update site will be made in `p2/target/repository` directory.
The update site can be used to perform a local installation.

# Development

Steps to get development environment setup based on https://github.com/knime/knime-sdk-setup#sdk-setup:

1. Install Java 8
2. Install Eclipse for [RCP and RAP developers](https://www.eclipse.org/downloads/packages/release/2018-12/r/eclipse-ide-rcp-and-rap-developers)
3. Configure Java 8 inside Eclipse Window > Preferences > Java > Installed JREs
4. Import this repo as an Existing Maven project
5. Activate target platform by going to Window > Preferences > Plug-in Development > Target Platform and check the `KNIME Analytics Platform (4.0) - nl.esciencecenter.e3dchem.sygma.targetplatform/KNIME-AP-4.0.target` target definition.

During import the Tycho Eclipse providers must be installed.

## Tests

Tests for the node are in `tests/src` directory.
Tests can be executed with `mvn verify`, they will be run in a separate KNIME environment.
Test results will be written to `test/target/surefire-reports` directory.
Code coverage reports (html+xml) can be found in the `tests/target/jacoco/report/` directory.

### Unit tests

Unit tests written in Junit4 format can be put in `tests/src/java`.

### Workflow tests

See https://github.com/3D-e-Chem/knime-testflow#3-add-test-workflow

## Speed up builds

Running mvn commands can take a long time as Tycho fetches indices of all p2 update sites.
This can be skipped by running maven offline using `mvn -o`.

# New release

1. Update versions in pom files with `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=<version>-SNAPSHOT` command.
2. Create package with `mvn package`, will create update site in `p2/target/repository`
3. Run tests with `mvn verify`
4. Optionally, test node by installing it in KNIME from a local update site
5. Append new release to an update site
  1. Make clone of an update site repo
  2. Append release to the update site with `mvn install -Dtarget.update.site=<path to update site>`
6. Commit and push changes in this repo and update site repo.
7. Create a GitHub release
8. Update Zenodo entry
  1. Correct authors
9. Make nodes available to 3D-e-Chem KNIME feature by following steps at https://github.com/3D-e-Chem/knime-node-collection#new-release
10. Update CITIATION.cff with new DOI


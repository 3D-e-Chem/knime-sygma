# SyGMa KNIME nodes

The [SyGMa](https://github.com/3D-e-Chem/sygma) [KNIME](https://www.knime.org) nodes for the **Sy**stematic **G**eneration of potential **M**et**a**bolites.

[![Build Status](https://travis-ci.org/3D-e-Chem/knime-sygma.svg?branch=master)](https://travis-ci.org/3D-e-Chem/knime-sygma)
[![SonarCloud Gate](https://sonarcloud.io/api/badges/gate?keynl.esciencecenter.e3dchem.sygma:nl.esciencecenter.e3dchem.sygma)](https://sonarcloud.io/dashboard?idnl.esciencecenter.e3dchem.sygma:nl.esciencecenter.e3dchem.sygma)
[![SonarCloud Coverage](https://sonarcloud.io/api/badges/measure?keynl.esciencecenter.e3dchem.sygma:nl.esciencecenter.e3dchem.sygma&metric=coverage)](https://sonarcloud.io/component_measures/domain/Coverage?idnl.esciencecenter.e3dchem.sygma:nl.esciencecenter.e3dchem.sygma)
[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.1033753.svg)](https://doi.org/10.5281/zenodo.1033753)

# Installation

Requirements:

* KNIME, https://www.knime.org, version 3.1 or higher
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

An Eclipse update site will be made in `p2/target/repository` repository.
The update site can be used to perform a local installation.

# Development

Steps to get development environment setup:

1. Download KNIME SDK from https://www.knime.org/downloads/overview
2. Install/Extract/start KNIME SDK
3. Start SDK
4. Install m2e (Maven integration for Eclipse) + Python wrapper + Test workflows in JUnit + 3D-e-Chem node category + RDKit

	
	1. Goto Window -> Preferences -> Install/Update -> Available Software Sites
    2. Make sure the following Software Sites (or a version of them) are present otherwise add them:

      * http://update.knime.org/analytics-platform/3.5
      * http://update.knime.org/community-contributions/trusted/3.5
      * https://3d-e-chem.github.io/updates
      * http://download.eclipse.org/eclipse/updates/4.6
      * http://download.eclipse.org/releases/neon

    3. Goto Help -> Check for updates
    4. Install any updates found & restart
    5. Goto Help > Install new software ...
    6. Select --All Available sites-- in work with pulldown
    7. Wait for list to be filled, `Pending...` should disappear
    8. Select the following items:

		* Abstract Python wrapper KNIME node and helpers
    	* Test Knime workflows from a Junit test
    	* Splash & node category for 3D-e-Chem KNIME nodes
    	* RDKit KNIME integration
    	* KNIME Base Chemistry Types & Nodes
    	* Test Knime workflows from a Junit test
    	
    9. Install software & restart

5. Import this repo as an Existing Maven project

After the import the Maven plugin connections must be setup, a Discover m2e connections dialog will popup to install all requested connectors, after the installation restart eclipse.

## Tests

Tests for the node are in `tests/src` directory.
Tests can be executed with `mvn verify`, they will be run in a separate KNIME environment.
Test results will be written to `test/target/surefire-reports` directory.

### Unit tests

Unit tests written in Junit4 format can be put in `tests/src/java`.

### Workflow tests

See https://github.com/3D-e-Chem/knime-testflow#3-add-test-workflow

# New release

1. Update versions in pom files with `mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=<version>-SNAPSHOT` command.
2. Commit and push changes
3. Create package with `mvn package`, will create update site in `p2/target/repository`
4. Append new release to an update site
  1. Make clone of an update site repo
  2. Append release to the update site with `mvn install -Dtarget.update.site=<path to update site>`
5. Commit and push changes in this repo and update site repo.
6. Make nodes available to 3D-e-Chem KNIME feature by following steps at https://github.com/3D-e-Chem/knime-node-collection#new-release


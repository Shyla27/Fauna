**WILDLIFE TRACKER**

This is an app that enables forest rangers monitor wildlife in a forest/park efficiently and effectively.

**DEVELOPED BY**

Mark Mwago

**Description**

The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. You have been asked to build an application that allows Rangers to track wildlife sightings in the area

**Technologies and frame works Used**

1. java 11
2. spark core 2.12
3. Gradle 4.10
4. HandlebarsTemplate Engine
5. Junit 5
6. Postgres database

**Known Bugs**

There are no known bugs at the moment.

**Usage**

To interact with the app, open the link at the top on another tab.
You can also clone the repo to your desktop and recreate databases by:

~~~~CREATE DATABASE wildlife_tracker;
\c wildlifetracker;
CREATE TABLE animals(id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar);
CREATE TABLE animals(id serial PRIMARY KEY,ranger_name varchar, location varchar, animal_id int, timestamp timestap);

CREATE TABLE endangered(id serial PRIMARY KEY,ranger_name varchar, location varchar, animal_id int, timestamp timestap);
CREATE DATABASE CREATE DATABASE wildlifetracker_test WITH TEMPLATE wildlifetracker;


**CONTACT**

To work with me, you can get me at markmwago@gmail.com


**LICENSE**
MIT 


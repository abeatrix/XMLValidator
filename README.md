# XMLValidator

Goal: Design a system that read XML files then process the files before feeding the output to another reporting system.

## Requirements:
- [x] One record at a time
- [x] Each record contains all accounts for a single user.
- [x] max 100 accounts per user
- [ ] max 100,000 user xml files per day
- [ ] REST service handle 100 messages max
- [ ] one user record for each message per second
- [ ] handle single batch file with user records via FTP at 2am daily
- [ ] combin all records into one single file at 1am daily
- [x] do not print account numbers in output
- [x] validation
- [ ] HA framework

## Conditions
- [ ] flexible output format: XML or JSON
- [x] allow addition aggregates per user to be added in the future
- [x] allow addition account type to be added in the future with the same element hierarchy

## Bonuses
- [ ] make up and implement missing important requirements

## Part I
1. describe and diagram overall system design
1. validation/verification
1. error handling
1. logging
1. performance considerations
1. libraries used:
    1. StAX for parsing XML file
    1. JAXP API for parsing XML file by constructing DOM
1. frameworks
1. software
1. hardware
1. cloud services
1. storage
1. cloud platform

## Part II
1. describe the code used to parse and process the data
1. UML to describe your class hierarchy and design patterns
1. advantages
1. disadvantages
1. reason of choice

``` I've tried StAX and JAXP for parsing and process the data, and found that ````

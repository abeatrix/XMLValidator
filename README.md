# XMLValidator

Goal: Design a system that read XML files then process the files before feeding the output to another reporting system.

## Requirements:
- [x] One record at a time
- [x] Each record contains all accounts for a single user.
- [x] max 100 accounts per user
- [ ] max 100,000 user xml files per day
- [ ] REST service handle 100 messages max
- [ ] one user record for each message per second
- [x] combin all records into one single file
- [ ] send combined file to receiving system at 1am daily
- [ ] receive single batch user records file at 2am daily
- [x] do not print account numbers in output
- [x] validation
- [ ] HA framework
- [ ] flexible output format: XML or JSON
- [x] allow addition aggregates per user to be added in the future
- [x] allow addition account type to be added in the future with the same element hierarchy

## Bonuses
- [ ] make up and implement missing important requirements

## Assumptions
* Receive and handle one user record at a time - no concurrency / data race
* Not required to do any sorting as it will handle by the receiving system - no data stucture required

## Part I
1. describe and diagram overall system design
1. validation/verification
    1. using schema to validate incoming data
    1. schema is flexible, allows addition aggregates in the future using xs:all tag
1. error handling
    1. throw exceptions when it does not pass validation
    1. TODO - add error to a different file
1. logging
    1. bufferedWriter to log incoming data
1. performance considerations
    1. limit operations and interations between system and cloud server by uploading output file when it reaches
    1. sacrifice memory space before output file is uploaded
    1. catch errors before process
1. libraries used:
    1. StAX for parsing XML file
    1. JAXP API for parsing XML file by constructing DOM
1. frameworks
    1. HA
1. software
1. hardware
1. cloud services
    1. AWS Cloud allows flexible output such as XML or JSON files
1. storage
1. cloud platform

## Part II
1. describe the code used to parse and process the data
1. UML to describe your class hierarchy and design patterns
1. advantages
1. disadvantages
1. reason of choice

``` I've tried StAX and JAXP for parsing and process the data, and found that ```

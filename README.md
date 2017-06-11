# simple-web-crawler

[![Build Status](https://travis-ci.org/krishnabitmca/simple-web-crawler.svg?branch=master)](https://travis-ci.org/krishnabitmca/simple-web-crawler)

A Web Crawler is a program that navigates the Web and finds new or updated pages for indexing. The Crawler starts with seed websites or a wide range of popular URLs (also known as the frontier) and searches in depth and width for hyperlinks to extract.

A Web Crawler must be kind and robust. Kindness for a Crawler means that it respects the rules set by the robots.txt and avoids visiting a website too often. Robustness refers to the ability to avoid spider traps and other malicious behavior. Other good attributes for a Web Crawler is distributive amongst multiple distributed machines, expandability, continuity and ability to prioritize based on page quality.

Here a very simple web crawler is implemented to demostrate how it works.
simple-web-crawler is an open source web crawler and scraper for Java which provides a simple interface for crawling the Web. This is specially design to crawl in the given domain due to restriction it will visit the entire pages on given domain and list down all the resources, imports and links. Depth of the crawling is configurable using input parameter.

## Table of content

- [Quickstart](#quickstart)
- [Approach](#approach)
- [Limitation](#limitation)
- [License](#license)

## Quickstart
Import as a Maven project in Eclipse.

![import](https://user-images.githubusercontent.com/20490848/27004584-d0973c56-4e28-11e7-8b15-51ba5d43f471.png)

Select Checkout Maven Project from SCM

![wizard](https://user-images.githubusercontent.com/20490848/27004595-207a68f6-4e29-11e7-8191-c1cfd1fe3e7a.png)

Click on Next button

Copy and paste https://github.com/krishnabitmca/simple-web-crawler.git this in git URL

![repository](https://user-images.githubusercontent.com/20490848/27004600-42ec4f76-4e29-11e7-9162-266b4e614578.png)

click on Finish

![imported](https://user-images.githubusercontent.com/20490848/27004621-a1e28464-4e29-11e7-832c-ac192061f5ad.png)

Right click on imported project and select Run As-> Maven test

![run](https://user-images.githubusercontent.com/20490848/27004648-3af50c80-4e2a-11e7-9f69-c941c14b0d6a.png)

### Build and Run using maven
* Install JDK 1.8 from http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

* Install Maven from https://maven.apache.org/download.cgi


* Clone project from github using following command.

$ git clone https://github.com/krishnabitmca/simple-web-crawler.git

* Goto project root folder.

cd simple-web-crawler

* Run maven command to build and run the project.

$ mvn test

## Approach

### The basic steps to write a Web Crawler are:

*  Pick a URL from the frontier.

*  Fetch the HTML code.

* Parse the HTML to extract links to other URLs.

*  Check if you have already crawled the URLs and/or if you have seen the same content before.

*  If not add it to the index.

*  For each extracted URL.

### Basic building block

![design](https://user-images.githubusercontent.com/20490848/27004775-03b68b42-4e2d-11e7-8f17-b4bdc6389cca.png)

### Libraries used 
This web crawler is using jsoup. It is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods.


jsoup implements the WHATWG HTML5 specification, and parses HTML to the same DOM as modern browsers do.

scrape and parse HTML from a URL, file, or string
find and extract data, using DOM traversal or CSS selectors
manipulate the HTML elements, attributes, and text
clean user-submitted content against a safe white-list, to prevent XSS attacks
output tidy HTML
jsoup is designed to deal with all varieties of HTML found in the wild; from pristine and validating, to invalid tag-soup; jsoup will create a sensible parse tree.
For further reading please got through https://jsoup.org/.

### Configuration 

All the dependencies and input parameters are provided through pom.xml. Following configuration takes the domain name and depth for crawler to search in domain. Make neccessary changes if you want to changes domain or depth.

![config](https://user-images.githubusercontent.com/20490848/27004930-69d09956-4e30-11e7-98d3-13a7aa4025a5.png)

## Limitation

*  Right now its not inteligent to filter if content is already extracted previously.
*  Although I have provided crawl depth parameter but it can be optimized for better crawling. 
*  Its not multi threaded.
*  Its not SSL enbled.
*  Politness feature is not available.
*  Unit test cases.

## License
Copyright (c) 2017 Krishna Singh

Published under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0), see LICENSE


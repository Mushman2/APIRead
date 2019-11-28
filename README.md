# Implementation

This Project contains two parts: 

- A tool to retrieve commit data from a Github repository using the Github API, and store it in a CSV file;
 
- A HTML file containing Javascript that uses the D3 Library to make graphs from the data in this file. 

### APIRead: 

The APIRead component of this project is a Kotlin program that retrieves the commit data from a specified github repository, and stores it in a CSV file. 

The program requires a Github username abd login token, as an unauthenticated client can only make 80 requests an hour before being rate limited by the API, while an authenticated user can make 5,000.

Given the name of the desired repository, and the name of it's owner, it will retrieve commit data and create a CSV file containing the Date, Author, Committer, Additions, Deletions, Total additionsa and deletions, Number of comments, and length of commit messages. 

### Frontend

The frontend of this project is a html file containing a Javascript script to generate graphs from the data provided by the APIRead program. 

It uses the D3 V4 library to create scatter plots visualising commit activity, 

### What data did I gather?

Finding a suitable dataset for this project proved to be difficult. Querying the API is time consuming, and rate limiting restricted me to datasets of less than 5,000. I found that the Github repository for the D3 library itself had just over 4,000 commits, and was suitable for my requirements. 

The main difficulty was deciding what exactly to graph, as the dataset is quite limiting. Almost all commits were made by one person, so I couldn't compare the work of multiple developers. 

### Conclusions

Unfortunately, I was unable to produce any actionable visualisations with my data. I had hoped correlate the length of the commit text or the number of comments with the number of lines in the commit, but I found no such correlation.

I believe my poor results to be the product of both a low data sample size (5,000 queries an hour is very small, especially when commits must be queried one by one to get information about lines added and deleted) and a poor choice of data. 


#### Reflections

This project provided many unforeseen challenges, especially when deciding what data I would aquire, and what I would be visualising. 

My lack of experience with Javascript and front-end development made working with the visualisation tools challenging


####Commit structure

This repo was originally copied from my LCA repo, and carried over the old commits. This was done to bring over the basic project structure and boilerplate.
This project starts at commit 7239332b 
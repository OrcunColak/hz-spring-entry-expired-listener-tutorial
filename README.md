# Read Me First

The original question is here  
https://stackoverflow.com/questions/78023606/use-eventlistener-causing-circular-dependency-with-repository

This project is configuring and EntryExpiredListener. From the EntryExpiredListener it is calling a service
in asynchronous fashion to delete the item from the repository


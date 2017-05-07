Details:
This is a spring boot Application that reads the data from an input file and calculates the estimates of the job. This Service can be accessed via REST API and the url is given below

Sample URL to hit the service

http://localhost:3005/papercutjobs
Method: GET

Output:

{"totalCost":6410,"jobsList":[{"totalPages":25,"colorPages":10,"doubleSided":false,"bwPages":15,"price":"475"},{"totalPages":55,"colorPages":13,"doubleSided":true,"bwPages":42,"price":"680"},{"totalPages":502,"colorPages":22,"doubleSided":true,"bwPages":480,"price":"5240"},{"totalPages":1,"colorPages":0,"doubleSided":false,"bwPages":1,"price":"15"}]}

New paper formats other than A4 can be added by accessing the below REST API call

http://localhost:3005/papercutjobs
Method: POST

Sample input
{"size":"A2","color":true,"doubleSided":true,"price":25}
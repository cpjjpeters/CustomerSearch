
# CustomerSearch

started from exampel
https://github.com/devrishal/use-case-tutorial/blob/master/jpa-specification/WireFrame.jpg


https://www.youtube.com/watch?v=W6wiTGYkCbo

To note: does not work with latest springboot version,
correction on 23/07/2025: 3.5.3 is working
(Customer_ was not created and then you cannot import it)
The RestController has not the name Controller in it

For Postman you need to be precise in writing the body:
{
"searchCriteria": [
{
"searchKey": "FIRST_NAME",
"searchValue": "CARL",
"operator": "EQUALS"
},
{
"searchKey": "LAST_NAME",
"searchValue": "PETERS",
"operator": "EQUALS"
}
,
{
"searchKey": "EMAIL",
"searchValue": "pm.me",
"operator": "LIKE"
}
,
{
"searchKey": "GENDER",
"searchValue": "m",
"operator": "LIKE"
}

]
}

# CustomerSearch

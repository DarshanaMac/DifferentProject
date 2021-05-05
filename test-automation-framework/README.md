This framework is developed by me since 2017 for my personal preferences. I am using this framework to implement given assignment. Separate command based use for web platform. Here i implemented reporting mechanism. As a reporting technique i used allure report.
Initial framework contains mobile automation as well as web service automation. Here i muted that parts.Only focusing Web automation.  

1. mvn install -Dmaven.test.skip=true  \n
2.Change webConfigData.xml testDataFilePath to resources folder. (E.g -D:\test-automation-framework\src\main\resources)
3.After executing if you need to check report - navigate to terminal and execute "allure serve" command

---- TEST CASES------

*createToDos
* MarkAsDone
* verifyCompletedToDosItems
*verifyFilterActiveTodos
*verifyClearCompletedTodos
*verifyCompletedTodos
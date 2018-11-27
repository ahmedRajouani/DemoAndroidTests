
Hi,

🎈 this is the solution of the test challenge.

-I used the page object pattern to create my tests.

In androidTest folder i created 3 folders:

1.tests -> MainActivityTestPage ( Login case, the up-to-date credential (username & password),Search for "sa", select the 2nd result,then click the call button.)


2.ui.pages -> four page objects (BasePage,LoginPage,SearchPage,DriverPage)


3.util -> 
- APICall for calling the Rest API using okHttp library i used the already create functions (fetchUser,fetchDriver) 
- Configuration for the Global parameters 
- EspressoIdlingResource and SimpleCountingIdlingResource for synchronization capabilities.


4.In the root you will find .circle/config.yml for the Deploy the tests on CircleCI

https://circleci.com/gh/ahmedRajouani/DemoAndroidTests


© 2018 GitHub, Inc.

# Selenium-I0015N
to run each Functionality you have to write the following for each functionality in "Driver.java"

LoginFunctionality:   "FacebookLoginLogout facebookLoginLogout = new FacebookLoginLogout(driver);
                       facebookLoginLogout.loginFunctionality();"

LogoutFunctionality:  "FaceBookLoginLogout facebookLoginLogout = new FaceBookLoginLogout(driver);
                       facebookLoginLogout.loginFunctionality()
                       facebookLoginLogout.logout();"
                      
PostFunctionality:    "Post post = new Post(driver);
                       post.Posta();
                       
SearchFunctionality   "SearchFunctionality searchFunctionality = new SearchFunctionality(driver);
                       searchFunctionality.searchFunctionality();
                       
in "Selenium-I0015N/src/main/java/com/example/Pages/" there's the page classes with all Xpaths
and in "Selenium-I0015N/src/main/java/com/example/" you can find all the functionalities, "userfunctionality", "searchfunctionality" and "post".

In "Selenium-I0015N/src/main/java/com/example/Config.java" theres functions to get all the relevant text from the Json file.

and in "Selenium-I0015N/src/main/resources/data.json" there's the text in the json file, you are free to look at the password since its a throw away       account and i'll delete it later.
           
In "Selenium-I0015N/loggingtest.log" you can find all the logs. its 3.2k lines long.

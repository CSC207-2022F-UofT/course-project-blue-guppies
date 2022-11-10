# Initial Setup 

Create directory XXX_XXX_use_case (XXX_XXX standing in for use case name).
Create test classes for each class in the corresponding use case folder 
under the name ClassTest (Class standing in for the actual name of the Class
being tested). 
 
For folder setup, follow the example linked below: 
https://github.com/paulgries/UserLoginCleanArchitecture/tree/main/test/user_register_use_case

For test class setup, IntelliJ can automatically generate these for us to start out with. 
For any directory in the src folder, IntelliJ can generate a test file for any 
class inside the directory, as long as there's a directory in the test folder with the same name 
as the directory in src. 

(05/11/22) Do this at some point later on, there's an issue with the way we're supposed to set up test files
(imports aren't working the way they should), which needs to be figured out before we can set up testing. 

# team3_fall18
Wallace Coleman, et al

# Quick Instructions

1. copy the dev3 package into an empty JavaFX project

2. copy Save.bin into the project at the same level as src, not in src

3. run Main.java

# Full instructions for use in eclipse:

1. Create a new JavaFx Project

2. File -> new -> other -> JavaFX -> JavaFX Project

3. delete the application package that is auto-generated

4. on git hub go to clone or download, and download the ZIP

5. extract the folder

6. in file explorer copy the dev3 folder into the src folder of the new JavaFX project

7. copy Save.bin into the project at the same level as the src folder, not in the src folder

8. Run Main.java

# if for some reason there is an issue with the Save.bin file

1. uncomment the first several lines that set up default groups, users, questions, and answers.

2. run the program once with those lines uncommented

3. recomment those lines and then now the save.bin will be created and the program should run normally

4. additionally if you wish to work with an empty site then only uncomment the last line:
  PersistenceManager.save(site, file);
  as before only run uncommented one time.

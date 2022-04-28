# Grades Histogram

## Contents

1. [Purpose of the project](#purpose-of-the-project)
2. [Requirements](#requirements)
3. [How to run the project](#how-to-run-the-project)
4. [LICENSE](#license-mit)


## Purpose of the project:

- This project is using Maven for better organization. So all the projects that are going to be made in this folder, will follow the maven structure.
- In this project there is a java script, that takes some grades from a .txt file and creates a frequency histogram for these grades.

##### [back to the contents](#contents)


## Requirements

- java
- maven
- grades.txt -- install the file [here](https://drive.google.com/file/d/1B6M0TNvrletoNk4xdvNLvXmbl4kDE5VF/view)

##### [back to the contents](#contents)


## How to run the project
- Clone the repository into your computer
- Inside the folder Software_Engineer_Assignments type:
```bash
$ mvn package
```
- Now there is a folder with the name gradeshistogram / target. Inside that folder there is a jar file with the name gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar . In order to run the project inside the target folder type:
```bash
$ java -jar gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar path/grades.txt
```
where the "path" is the path that the file grades.txt is installed in your computer.

##### [back to the contents](#contents)


## License MIT

Project License can be found [here](LICENSE.md).

##### [Back to Contents](#contents)



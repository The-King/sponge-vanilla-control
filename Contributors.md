# Contribution Guidelines

There is no such thing as a perfect project and things can always be improved.
If you are a developer and are interested in helping then please do not hesitate.
Just make sure you follow our guidelines.

* Line endings
    * Use Unix line endings when committing (\n)
    * Windows users of Git can do git config --global core.autocrlf true to let Git convert them automatically
     
* Column width
    * 80 for Javadocs
    * 150 for code
    * Feel free to wrap when it will help with readability
    
* Indentation

Use 4 spaces for indentations, do not use 2 spaces
    
* Vertical whitespace

Place a blank line before the first member of a class, interface, enum, etc. (i.e. after class Example {) as well as after the last member)
    
* File headers

File headers must contain the license headers for the project. Use the licenseFormat Gradle task to add them automatically.

* Javadocs
    * Do not use @author
    * Wrap additional paragraphs in <p> and </p>
    * Capitalize the first letter in the descriptions within each “at clause”, i.e. @param name Player to affect, no periods
    
* Open a pull request with your changes.
* Please follow the above guidelines for your pull request(s) to be accepted.
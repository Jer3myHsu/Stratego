# Stratego
**This is a Minecraft themed Stratego game**

This is how to set up Git on command line
https://help.github.com/articles/set-up-git/#setting-up-git

This is how to use Git commands. Start from 5:46
https://www.youtube.com/watch?v=0fKg7e37bQE

## To summarize routine
1. Get the latest version by using:
```
git pull
```
2. do all your coding business
3. Check the files that you have modified/created
```
git status
```
4. Add your new/modified files (enter the file name or enter -A to add all):
```
git add
```
5. Put a message that tells everyone what you did. Ex: "Added attack methods"
```
git commit -m "ENTER COMMENT HERE" 
```
6. Sends your changes to main repository
```
git push
```
   
### Note:
You can commit and push every time you make a major modification.

If you are working for long, you might want to pull time to time to make sure you have the latest version.

To avoid merge conflict and constant pulling please notify when you are working.

If you do get a merge conflict, do not panic, just fix the problem and git add and git commit without a comment.
According to the video you will get a screen that pops up if you commit with out a comment. Use "esc :wq" to get out of it

# General Comments and Chat
**Put any comments you want us to see here.**
 
If you need to bold or etc: https://help.github.com/articles/basic-writing-and-formatting-syntax/

**Jeremy:** So we are currently not using Synth look and feel but tbh I kinda want to bc there is a lot we can do with it. Currently, we can only color component's background, foreground, and border (if supported) and will have no texture. But with Synth look and feel we can use image painters and design actual legit buttons for example the top right exit button. Check out some stuff I have been designing in Images\texture folder. The reason we can't use Synth laf is bc I'm having problems modifying the JProgressBar, JMenu (and its inner components), and the JPanel. Once I figure out how to get those working, I we will switch to Synth laf. If you want to know more about Synth, use google.

About the splash screen. The way we did it is technically not the correct way of doing it. We created a JWindow (which is basically JFrame without the minimize-expand-exit thing) and made it look like a splash screen. A real splash screen is created using the SplashScreen object. _"Well what's the difference?"_ The purpose of a splash screen is not just to look cool on start up but to provide the user with feedback telling them that the program has started. Since we are using a JWindow, the start up will take the same time as if it were to just open the main JFrame therefore making the JWindow useless. _"So why doen't we just use the actual SplashScreen?"_ I can get it to kinda work but it will only work if we run the program from the command line and that is kinda annoying. I'm guessing the reason it has to be from the command line is bc it receives the image path as it runs therefore it won't spend time reading the code. This results with a fast splash screen start up. We might look more into this near the completion of this program so we don't have to keep running from the command line.
 


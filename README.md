# Stratego
**This is a Minecraft themed Stratego game**

This is how to [set up Git](https://help.github.com/articles/set-up-git/#setting-up-git) on command line

This is how to use Git [commands](https://www.youtube.com/watch?v=0fKg7e37bQE). Start from 5:46

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

# Checklist
1. ~~Design~~: Basically done
2. Start Phase: All is that is left is to put the tool tip back after it is disabled and set coorinates to the pieces 
3. Battle Phase: Didn't Start
4. End Phase: Idk if we even need this phase
5. Menu bar: Moving in a decent progress

# What are each Object for?
Game: This is the main Object and the code to control the game is stored here

PieceTemplate: This is the basic outline that all the pieces will follow

(Unique Pieces) EnderDragon, miner, etc...: This uses the PieceTemplate and fills it with information that is unique compared to others like strength, team, and position

Piece: This is used to organize the Unique Pieces so the Game object won't be so messy and long. All the long if statements go here to retrieve the Unique Pieces to Game. **Btw we should use our knowledge of recursion, sorting and searching to make this more neat. Try if possible**

# General Comments and Chat
**Put any comments you want us to see here.**
 
If you need to [bold or etc](https://help.github.com/articles/basic-writing-and-formatting-syntax/)

**Jeremy:** Synth look and feel needs minor fixes.

About the splash screen. The way we did it is technically not the correct way of doing it. We created a JWindow (which is basically JFrame without the minimize-expand-exit thing) and made it look like a splash screen. A real splash screen is created using the SplashScreen object. _"Well what's the difference?"_ The purpose of a splash screen is not just to look cool on start up but to provide the user with feedback telling them that the program has started. Since we are using a JWindow, the start up will take the same time as if it were to just open the main JFrame therefore making the JWindow useless. _"So why doen't we just use the actual SplashScreen?"_ I can get it to kinda work but it will only work if we run the program from the command line and that is kinda annoying. I'm guessing the reason it has to be from the command line is bc it receives the image path as it runs therefore it won't spend time reading the code. This results with a fast splash screen start up. We might look more into this near the completion of this program so we don't have to keep running from the command line.

If we do use the proper splash screen then we don't need to worry about synth progress bar, so issa win win.
 


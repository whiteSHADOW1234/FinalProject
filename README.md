# FinalProject - 進撃のPingPong


## Set up the environment
#### 1. Install Vscode 
Hmmm, I think you know how to do this right?


#### 2. Install Java in Vscode 
You could try this:

https://code.visualstudio.com/docs/java/java-tutorial

Then, create a folder in which you would like to run this project and open it.



#### 3. Install JavaFx in Vscode 
1. Press the "new configurations" button which is under the Run button above your window.
2. Add the java configuration sentence in the launch.json file

   __Do not forget to change "\\" to "/" in the path of your javafx-sdk__
```
"vmArgs": "--module-path /Users/<user>/Downloads/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.media",
```

* Your Java configuration should look like this
![](https://i.imgur.com/sfXtJg8.png)


3. Import all the Java's JRE & JavaFX's jar in the lib

    ![](https://i.imgur.com/7xCGvRb.png)

4. 😃Well Done!!!


#### 4. Find a friend to play this game with you ~

Or you can just play this game with your hands(/the AI) if you don't have any friends...

## Game Parts
#### I will use this type of word to represent *RIGHT[BLUE] PLAYER*.

#### And use this type of word to represent (LEFT[RED] PLAYER).





## Game Starting Scene
### Include:
+ Nice looking background (Main Scene)
+ Game Start Button (with a spinning animation)
+ Setting Button (with a spinning animation)
+ Developer Info Button (with a spinning animation)
+ Enable to play the music while playing this game


### Description:
This is the first screen that pops up after you run this project on your device which had to finish setting up the environment.

You will probably see three buttons float up.

After pressing the Game Start Button, you'll enter the Mode Selecting Page.

After pressing the Setting Button, you'll enter the Game Setting Page.

After pressing the Developer Info Button, you'll enter the Developer Info Page.



## Mode Selecting Page
### Include:
+ Nice looking background (Mode Selecting scene)
+ Basic Mode Button
+ Advance Mode(PVE) Button
+ Super Mode(Infinity Balls) Button 
+ Back Button

### Description:
There are three buttons on this screen.

After pressing the Basic Mode Button, you'll enter the Basic Mode.

After pressing the Advance(PVE) Mode Button, you'll enter the Advance(PVE) Mode.

After pressing the Super Mode Button, you'll enter the Super(Infinity Balls) Mode.

After pressing the Back Button, you'll get back to the Game Starting Scene.



## Game Setting Page
### Include:
+ Volume Bar with the number changing while the user dragging it
+ Mute Button (change color while you tap on it)
+ AI Speed customize Check Box with a text field and confirm button (change color while you tap on it) pops up after checking it
+ Back button (change color while you tap on it)
+ Nice looking background (setting scene)

### Description:
Set the volume of the music by dragging the bar or pressing the mute button in the setting scene.

After checking the AI speed customize button, you could set the red side's speed in PVE mode.

Oh, don't forget to press the confirm button!!!

(*Some secret things are hiding in here...*)


## Developer Info Page
### Include:
+ Nice looking background (Developer Info Scene)
+ Four names of the game developers 
+ Email to contact us
+ A Text Bar (to enable beta mode)
+ A difference music playing in the background

### Description:
:smile:You can see our name with handwriting animation and the way to contact us here !!! 
You could enter some words in the Text Bar and you will get the hint.
(*Some secret things are hiding in here...*)





## End Scene
### Include:
+ Nice looking background (Ending Scene)
+ Great firework GIF
+ Restart button (change color while you tap on it)
+ Quit button (change color while you tap on it)
+ Winner(or the balls player caught) will be shown in this scene

### Description:
Players could see who's the winner(or the balls player caught in Super Mode) in this game on this page.

After you press the Restart button, you will jump to the Game Starting Scene.

After you press the Quit button, you will quit this game.





## Basic Mode (Normal)
### Include:
+ Nice looking background (basic game scene)
+ Two paddles with different colors and white parts
+ One ping pong ball starts moving in the middle of the scene
+ Two energy bars on the top of the game window 
+ Scores of each side will be shown on the top of the game window
+ Player who gets eleven points first is the winner

### Description:

There is one ball that pops up and bounces between the up and down edges of the game window and paddles.

Players should move the paddles by pressing *W/S*(up/down) keys to avoid the ball touching the edge behind them.

Every time the ball touches one's paddle, the energy bar of one's side will be added.

㊙️*If the ball hits the white parts of your paddle, your energy bar will be added some extra points*

Players could hit the *D*(/left arrow) key to change the ball's direction while the energy bar of his/her side was filled.

Try to get eleven points first and you will win this game, good luck:smile:





## Advance Mode(PVE): made for those players who don't have friends
### Include:
+ Nice looking backgrounds (Basic Game Scene)
+ Two different colors of paddles with white parts
+ One ping pong ball starts moving in the middle of the scene
+ Two energy bars on the top of the game window 
+ Two scores will be shown on the top of the game window
+ Player who gets eleven points first is the winner


### Description:
The red side player is the AI.

:warning:*You could change the speed of it on the game setting page*

There is one ball that pops up and bounces between the up and down edges of the game window and paddles.

The player should move the paddle by pressing *W/S* keys to avoid the ball touching the edge behind it.

Every time the ball touches one's paddle, the energy bar of one's side will be added.

㊙️*If the ball hits the white parts of your paddle, your energy bar will be added some extra points*

The player could hit the *D* key to change the ball's direction while the energy bar of his/her side was filled.

Try to get eleven points first and you will win this game, good luck:smile:

⚠️The AI knows how to play our game. 





## Super Mode (Infinity Ball)
+ One blue paddle (a little bigger than the other mode) with a white part
+ Nice looking background (Super Mode Scene)
+ Lots of white balls were thrown from the right of the window
+ One left energy bar will be shown on the top of the game window 
+ Top left number shows how many balls do the player catch
+ Top right number(<= 60 sec) shows how much time do player left to end this game.
+ Special ending screen (which shows how many balls do player caught)

### Description:
After entering this mode, you might see lots of balls throwing from the right side of this window.

Try to keep these balls out of the wall behind your paddle by pressing the W/S key.

This game will give you 60 seconds(shown on the top-right side) to complete this task.

Also, the number on the top-left side will show how many balls do player caught.

The ending page in this mode shows how many balls do player caught in 60 seconds.

Player could hit the *D* key to change all the balls direction on the window while the energy bar of his/her side was filled.


## Beta Mode 
:warning: You Should Not See This If You Aren't The Game Developer!!!:warning:

*Enter the Developer Info Page and you will get some clues for this......* 
### The Greatest Mode ------
Every thing in here are secrets

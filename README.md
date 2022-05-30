# FinalProject - 進撃のPingPong



## Set up the environment
#### 1. Install Vscode 
Hmmm, I think you know how to do this right ?

So I'm not going to write this, wa ha ha ha.



#### 2. Install Java in Vscode 
You could try this:

   https://code.visualstudio.com/docs/java/java-tutorial

Then, create a file which you would run this project in and open it.



#### 3. Install JavaFx in Vscode 
1. Press the "new configurations" button which is under the Run button above your window.
2. Add the configuration sentence in the java configuration
   __Change "\" to "/" in the path of your javafx-sdk__
```
"vmArgs": "--module-path /Users/<user>/Downloads/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.media",
```

* Java configuration should looks like this
![](https://i.imgur.com/sfXtJg8.png)



3. Import Java's & JavaFX's JRE in the refer lib

![](https://i.imgur.com/7xCGvRb.png)

4. 😃Done!!!


#### 4. Find a friend to play this game with you ~

Or you can just play this game with your hands(/the AI) if you don't have any friends...

I will use this type of words to represent *RIGHT[BLUE] PLAYER*.

And use this type of words to represent (LEFT[RED] PLAYER).





## Game Starting Scene
### Include:
+ Nice looking backgrounds (main scene)
+ Game Start Button
+ Setting Button
+ Enable to play the music while playing this game

### Description:
This is the first screen which pops up after you run this project on your device which had finish setting up the environment.

you will probably see two buttons on it.

After pressing the Game Start Button, you'll enter the Mode Selecting Page.

After pressing the Setting Button, you'll enter the Game Setting Page.







## Mode Selecting Page
### Include:
+ Nice looking backgrounds (mode selecting scene)
+ Basic Mode Button
+ Advance Mode(PVE) Button
+ Super Mode Button (Not activated right now)

### Description:
There are three buttons on this screen.

After pressing the Basic Mode Button, you'll enter the Basic Mode.

After pressing the Advance(PVE) Mode Button, you'll enter the Advance(PVE) Mode.

After pressing the Super Mode Button, you'll enter the Super Mode.






## Game Setting Page
### Include:
+ Volume Bar with number changing while user dragging it
+ Mute Button
+ AI Speed customize Check Box with a textfield and confirm button after checking it
+ Back button
+ Nice looking backgrounds (setting scene)

### Description:
Set the volume of the music by dragging the bar or pushing mute button in the setting scene.

After checking the AI speed customize button,you could set the red side's speed in PVE mode.

Oh, don't forget to press the confirm button!!!
  *There are some secret things hidding in here...*
  
After customize your setting do not forget to press the Back button to confirm your changes.





## End Scene
### Include:
+ Nice looking backgrounds (ending scene)
+ Great firework GIF
+ Restart button
+ Quit button
+ Winner will be shown on this scene

### Description:
PLayers could see who's the winner in this game on this page.

After you press the Restart button, you will jump to the Game Starting Scene.

After you press the Quit button, you will quit this game.













## Basic Mode 
### Include:
+ Nice looking backgrounds (basic game scene)
+ Two different colors paddles with white parts
+ One ping pong ball starts moving in the middle of the scene
+ Two energy bars on the top of the game window 
+ Two scores will be shown on the top of the game window
+ Player who gets two points first is the winner

### Description:

There is one ball which pops up and bounce between the up and down edges of game window and paddles.

Players should move the paddles by pressing *W/S*(up/down) keys to avoid the ball touches the edge behind them.

Every time the ball touches one's paddle, the energy bar of one's side will be added.

*Secret: If the ball hits the white parts of your paddle, your energy bar will be added some extra points*

Player could hit the *D*(/left arrow) key to change the ball's direction while the energy bar of his/her side was filled.

Try to get two points first and you will win this game, good luck.










## Advance Mode(PVE) 
### Include:
+ Nice looking backgrounds (basic game scene)
+ Two different colors paddles with white parts
+ One ping pong ball starts moving in the middle of the scene
+ Two energy bars on the top of the game window 
+ Two scores will be shown on the top of the game window
+ Player who gets two points first is the winner


### Description:
The red side player is the AI.

*You could change the speed of it in the game setting page*

There is one ball which pops up and bounce between the up and down edges of game window and paddles.

Player should moves the paddle by pressing *W/S* keys to avoid the ball touches the edge behind them.

Every time the ball touches one's paddle, the energy bar of one's side will be added.

*Secret: If the ball hits the white parts of your paddle, your energy bar will be added some extra points*

Player could hit the *D* key to change the ball's direction while the energy bar of his/her side was filled.

Try to get two points first and you will win this game, good luck.

⚠️The AI knows how to play our game. 





## Super Mode 
Not available yet......
(The Game Developers are still playing online games...)








## Beta Mode 
:warning: You Should Not See This If You Aren't The Game Developer!!!:warning:

*If you change the boolean value "beta" on the 30th line of GamePanel.java to true you will enter to the greatest mode of this game......* 
### The Greatest Mode ------
You will have full-white paddles and some super power ~







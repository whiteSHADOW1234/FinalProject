# FinalProject - 進撃のPingPong



## Set up the environment
#### 1. Install Vscode 



#### 2. Install Java in Vscode 






#### 3. Install JavaFx in Vscode 
1. Add the configuration sentence in the java configuration

```
"vmArgs": "--module-path /Users/<user>/Downloads/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.media",
```

* Java configuration should looks like this
![](https://i.imgur.com/sfXtJg8.png)

2. Do not forget to download this configuration
    * Here is the URL:
https://jar-download.com/artifacts/com.googlecode.soundlibs/jlayer/1.0.1.4/source-code

![](https://i.imgur.com/YY2UGRA.png)


3.  And put it in the refer lib

![](https://i.imgur.com/7xCGvRb.png)

#### 4. Find a friend to play this game with you ~
*RIGHT[BLUE] PLAYER* && (LEFT[RED] PLAYER)
Or you can just play this game with your hands if you don't have friends...







## Main Game Scene
+ Nice looking backgrounds (main scene)
+ Game Start Button
+ Setting Button

### Description:
This is the first screen which pops up after you run this project on your device which had finish setting up the environment.

you will probably see two buttons on it.

After pressing the Game Start Button, you'll enter the Mode Selecting Page.

After pressing the Setting Button, you'll enter the Game Setting Page.







## Mode Selecting Page
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








## Basic Mode 
+ Nice looking backgrounds (includes start scene, game scene and the end scene)
+ Two buttons(game start & setting) on the start scene
+ Two different colors paddles with white parts
+ One ping pong ball starts moving in the middle of the scene
+ Enable to play the music while playing this game
+ Two energy bars on the top of the game window 
+ Two scores will be shown on the top of the game window 
+ Player who gets two points first is the winner
+ Two buttons(restart & quit), a GIF and the winner will be shown on the end scene
### Description:

There is one ball which pops up and bounce between the up and down edges of game window and paddles.

Players should move the paddles by pressing *W/S*(up/down) keys to avoid the ball touches the edge behind them.

Every time the ball touches one's paddle, the energy bar of one's side will be added.

*Secret: If the ball hits the white parts of your paddle, your energy bar will be added some extra points*

Player could hit the D(/left arrow) key to change the ball's direction while the energy bar of his/her side was filled.

Try to get two points first and you will win this game, good luck.


## Advance Mode(PVE) 
+ 
### Description:
Not available yet......
(The Game Developers are playing online games now)


## Super Mode 
Not available yet......
(The Game Developers are still playing online games...)





## Beta Mode 
:warning: You Should Not See This If You Aren't The Game Developer!!!:warning:

*If you change the boolean value "beta" on the 30th line of GamePanel.java to true you will enter to the greatest mode of this game......* 
### The Greatest Mode ------
You will have full-white paddles and some super power ~









------
更新日誌：
* 05.20.15:58 GamePanel 第37行的beta設為真時，魔力值預設全滿，白色區域全滿
* 05.20.11:36 現在擊中paddle會增加魔力條，擊中白色區域會增加更多

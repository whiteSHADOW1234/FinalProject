# FinalProject - 進撃のPingPong

## Set up the environment
#### 1. Install Vscode 



#### 2. Install Java in Vsode 






#### 3. Install JavaFx in Vsode 
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

## Game Setting Mode
+ Control the volume of the music
+ Nice looking backgrounds (setting scene)
### Description:
Player could set the volume of the playing music by dragging the bar in the setting scene.



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
First run this project on your device which had finish setting up the environment
and you will probably see two buttons on the start screen.
##### After pushing the Setting button:
You will enter the setting mode and you could change the playing music's volume.
##### After pushing the Game start button:
There is one ball which pops up and bounce between the up and down edges of game window and paddles.

Players should move the paddles by pressing W/S(up/down) keys to avoid the ball touches the edge behind them.

Every time the ball touches one's paddle, the energy bar of one's side will be added.

*Secret: If the ball hits the white parts of your paddle, your energy bar will be added some extra points*

Player could hit the right/left arrow key to change the ball's direction while the energy bar of his/her side was filled.

Try to get two points first and you will win this game, good luck.


## Advance Mode ------
Not available yet......(The Game Developers are playing online games now)


## Super Mode ------
Not available yet......(The Game Developers are stil playing online games...)





## Beta Mode 
:warning: You Should Not See This If You Aren't The Game Developer!!!:warning:

*If you change the boolean value "beta" on the 30th line of GamePanel.java to true you will enter to the greatest mode of this game......* 
### Greatest Mode ------
You will have full-white paddles and some super power ~










更新日誌：
* 05.20.15:58 GamePanel 第37行的beta設為真時，魔力值預設全滿，白色區域全滿
* 05.20.11:36 現在擊中paddle會增加魔力條，擊中白色區域會增加更多

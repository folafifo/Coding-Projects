final color white = color(255);
final color black = color(0);
final color red = color (#FF0A27);
final color yellowish = color(255, 204, 0);
final int SCREENX = 500;
final int SCREENY = 500;
final int PADDLEHEIGHT = 30;
final int PADDLEWIDTH = 100;
final int MARGIN = 10;
boolean gameOn = true;
int noOfPlayerLives ;
int noOfComputerLives;
Player thePlayer;
Ball theBall;
Computer theComputer;

void settings() {
  size(SCREENX, SCREENY);
}

void setup() { 
  thePlayer = new Player(SCREENY-MARGIN-PADDLEHEIGHT);
  theBall = new Ball();
  theComputer = new Computer();
  noOfPlayerLives = 3;
  noOfComputerLives =3;
  ellipseMode(RADIUS);
  frameRate(200);
  PFont myFont = loadFont("Serif-48.vlw");
  textFont(myFont);
}
void gameOverPlayer(Ball theBall) {
  if ( theBall.y > 500) {
    noOfPlayerLives--;
    if (noOfPlayerLives <=0) {
      gameOn = false;
    }
  }
}
void gameOverComputer(Ball theBall) {
  if ( theBall.y <0 ) {
    noOfComputerLives--;
    if (noOfComputerLives <=0) {
      gameOn = false;
    }
  }
}
void draw() {
  if (gameOn) {
    background(255);
    thePlayer.move(mouseX);
    theBall.move();
    theComputer.move(theBall);
    theBall.collide(thePlayer);
    theBall.collide(theComputer);
    thePlayer.draw();
    theBall.draw();
    theComputer.draw();
    checkForReset();
  }

  if (noOfPlayerLives==0) {
    background(0);
    text(" Game Over!!! ", 125, 250);
  }
  if ( noOfComputerLives==0) {
    background(0);
    text (" You Win!!! ", 125, 250);
  }
}
void checkForReset() {
  if ( (theBall.y > 500)||(theBall.y<0)) {
    if (mousePressed) {
      gameOverPlayer(theBall);
      gameOverComputer(theBall);
      theBall.x = random(SCREENX/4, SCREENX/2);
      theBall.y = random(SCREENY/4, SCREENY/2);
    }
  }
}

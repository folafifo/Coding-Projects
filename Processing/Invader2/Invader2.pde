Bullet theBullet; //<>//
Player thePlayer;
Alien theAliens[];
Shield theShield;
boolean canShoot;
boolean gameOver;
boolean youWin;
boolean shieldDead;
boolean bombDisp;
void settings() {
  size(SCREENX, SCREENY);
}
void init_aliens(Alien baddies[], PImage okImg, PImage exImg) {
  for (int i=0; i<baddies.length; i++) { 
    baddies[i] = new Alien(i*(okImg.width+GAP), 0, okImg, exImg);
  }
}
void setup() {
  canShoot = true;
  gameOver = false;
  youWin = false;
  shieldDead = false;
  bombDisp = false;
  PImage normalImg, explodeImg;
  PFont myFont = loadFont("Serif-48.vlw");
  textFont(myFont);
  normalImg= loadImage("invader.GIF");
  explodeImg = loadImage("exploding.GIF"); 
  thePlayer = new Player(SCREENY-MARGIN-PADDLEHEIGHT);
  theAliens = new Alien[10]; 
  theShield = null;
  init_aliens(theAliens, normalImg, explodeImg);
}

void draw() {
  if ((!gameOver)&&(!youWin)) {
    background(0);

    thePlayer.move(mouseX);
    thePlayer.draw();
    if ((int(random(0, 750)) == 125)) {
      theShield = new Shield(thePlayer);
    }
    if (theShield!=null) {
      theShield.move(thePlayer.x()-10);
      theShield.draw();
    }

    if (theBullet!= null) {
      theBullet.move();
      theBullet.draw();
      theBullet.collide(theAliens);
      if (theShield!=null) {
        theBullet.collideShield(theShield);
      }
    }
    for (int i=0; i<theAliens.length; i++) {
      theAliens[i].move(); 
      theAliens[i].draw();
      Bomb aBomb = theAliens[i].getBomb(); 
      if (aBomb!= null) {
        aBomb.move();
        aBomb.draw();
        if ((aBomb.collidePlayer(thePlayer))) {
          gameOver = true;
        }
        if (theShield!=null) {
          if (aBomb.collideShield(theShield)) {
          }
        }
      }
    }

    youWin = aliensDead(theAliens);
    if (theShield!=null) {
      shieldDead = theShield.healthZero();
      if (shieldDead) {
        theShield = null;
      }
    }
  } else if (gameOver) {
    background(0);
    text("Game Over!!!", 130, 250);
  } else if (youWin) {
    background(0);
    text("You Win!!!", 130, 250);
  }
}
void mousePressed() {
  if (canShoot)
    theBullet = new Bullet(thePlayer.xpos);
}
boolean aliensDead(Alien someAliens[]) {
  for (int i=0; i<someAliens.length; i++) {
    if (someAliens[i].getStatus() != ALIEN_DEAD) {
      return false;
    }
  }
  return true;
}

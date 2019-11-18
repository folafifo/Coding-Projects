
class Alien {
  PImage invader, exploding;
  float wave, angle, velocity;
  int x, y, radius, counter, deadCounter; 
  int  randomSpecial, randomExplode, randomDirection;
  color AlienColor;
  boolean moveRight, moveLeft;
  boolean moveDown, exploded, special;

  Alien (int xpos, int ypos) {
    x = xpos; 
    y = ypos;  

    radius = int(random(15, 40));
    velocity = random(1, 4);

    if ((randomDirection = int(random(0, 2))) == 1)
      moveRight = true;
    else
      moveLeft = true;
if ((randomSpecial = int(random(0, 2))) == 1)
      special = true;
    invader = loadImage("invader.GIF");
    exploding = loadImage("exploding.GIF");
  }
 void explode() {
    for (int i = 0; i < myAliens.length; i++) {
      if ((randomExplode = int(random(1, 30000))) == 75)
        myAliens[i].exploded = true;
    }
  }
  void draw() {
    if (exploded)
      image(exploding, x, y, radius, radius);

    else if (special)
      image(invader, x, y + wave, radius, radius);
    else
      image(invader, x, y, radius, radius);

    explode();
  }

  void move() {
    wave = 25*sin(angle);
    angle += 0.1;
    
    if (frameCount % 1000 == 0){
      velocity += 1;
    }
    if (x >= SCREENX - radius || x <= 0){
      moveDown = true;
    }
    if (moveRight){
      x += velocity;
    }
    if (moveLeft){
      x -= velocity;
    }
    if (moveDown) {      
      if (x <= 0 || x >= SCREENX - radius) {
        y++;
        counter++;
        moveRight = false;
        moveLeft = false;
        if ((counter >= radius) && x <= 0) {
          counter = 0;
          moveRight = true;
          moveLeft = false;
        }
        
        if ((counter >= radius) && x >= SCREENX - radius) {
          counter = 0;
          moveRight = false;
          moveLeft = true;
        }
      }
    }
  }
}

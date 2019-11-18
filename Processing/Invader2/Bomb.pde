class Bomb {
  int xpos, ypos, radius ;
  color bombColor = color(255, 0, 0);
  Bomb(int x, int y) {
    xpos = x;
    ypos = y;
    radius = BOMB_RADIUS;
  }
  int x() {
    return xpos;
  }
  int y() {
    return ypos;
  }
  void move() {

    ypos+=3;
  }
  void draw() {

    fill(bombColor);
    ellipse(xpos, ypos, radius, radius);
  }
  boolean offScreen() {
    if (ypos > SCREENY) {
      return true;
    }
    return false;
  }
  boolean collidePlayer(Player player) {
    if ((ypos>= player.y())&&(ypos<= player.y()+PADDLEHEIGHT)&&(xpos+radius>= player.x())&&(xpos+radius<=player.x()+PADDLEWIDTH)) {
      return true;
    }
    if ((ypos>= player.y())&&(ypos<= player.y()+PADDLEHEIGHT)&&(xpos-radius>= player.x())&&(xpos-radius<=player.x()+PADDLEWIDTH)) {
      return true;
    }
    return false;
  }
  boolean collideShield(Shield shield) {
    if ((ypos>= shield.y())&&(ypos<= shield.y()+SHIELD_HEIGHT)&&(xpos+radius>= shield.x())&&(xpos+radius<=shield.x()+SHIELD_WIDTH)) {
      shield.health -= 100;

      return true;
    }
    if ((ypos>= shield.y())&&(ypos<= shield.y()+SHIELD_HEIGHT)&&(xpos-radius>= shield.x())&&(xpos-radius<=shield.x()+SHIELD_WIDTH)) {
      shield.health -= 100;
      return true;
    }
    return false;
  }
}

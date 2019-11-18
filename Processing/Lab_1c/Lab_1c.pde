int i;
int q;

void setup() {
  size(500, 500);
  noStroke();
  fill(0, 204, 4);
  i =0;
  q=449;
}
void draw() {
  background(255);
  rect(i, 20, 100, 100); 
  
  rect(q, 300, 100, 100); 
  
  if (i+100>=499) {
      rect(i-500, 20, 100, 100);
  }
 
  if (q<=0) { 
     { 
      rect(q+500, 300, 100, 100);
    }
    
  }
  if (i>=499) i=0;
  if (q<=-100) q=399;
  i++;
  q--;
}

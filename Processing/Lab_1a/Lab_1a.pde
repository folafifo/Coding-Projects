int i;

void setup(){
size(500,500);
noStroke();
fill(255,180,0);
i =0;




}
void draw(){
background(255);
rect(i, 20, 100, 100); 
if(i++>=499) i=0;



}



class something {
JSONObject obj;
String lines[] = loadStrings("news.txt");
}
//println("there are " + lines.length + " lines");
for (int i=0; i < 20; i++) {
  println(lines[i]);
  obj = parseJSONObject(lines[i]);
}
 obj.getString("kids");
}

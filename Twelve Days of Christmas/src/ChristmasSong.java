
public class ChristmasSong {
	public static final String TRUE_LOVE = "my true love sent to me:";
	public static final String PATRIDGE = "A partridge in a pear tree.";
	public static final String DOVES = "Two turtle doves, and";
	public static final String HENS = "Three french hens";
	public static final String BIRDS = "Four colly birds";
	public static final String RINGS = "Five gold rings";
	public static final String GEESE = "Six geese a-laying";
	public static final String SWANS = "Seven swans a-swimming";
	public static final String MAIDS = "Eight maids a-milking";
	public static final String LADIES = "Nine ladies dancing";
	public static final String LORDS = "Ten lord a-leaping";
	public static final String PIPERS = "Eleven pipers piping";
	public static final String DRUMMERS = "Twelve drummers drumming";
	public static final int MAX_DAYS = 12;

	public static void main(String[] args) {
		for (int day = 1; (day <= MAX_DAYS); day++) {
			switch (day) {
			case 1:
				System.out.println("On the first day of Christmas");
				break;
			case 2:
				System.out.println("On the second day of Christmas");
				break;
			case 3:
				System.out.println("On the third day of Christmas");
				break;
			case 4:
				System.out.println("On the fourth day of Christmas");
				break;
			case 5:
				System.out.println("On the fifth day of Christmas");
				break;
			case 6:
				System.out.println("On the sixth day of Christmas");
				break;
			case 7:
				System.out.println("On the seventh day of Christmas");
				break;
			case 8:
				System.out.println("On the eighth day of Christmas");
				break;
			case 9:
				System.out.println("On the ninth day of Christmas");
				break;
			case 10:
				System.out.println("On the tenth day of Christmas");
				break;
			case 11:
				System.out.println("On the eleventh day of Christmas");
				break;
			case 12:
				System.out.println("On the twelfth day of Christmas");
				break;
			default:
			}
			System.out.println(TRUE_LOVE);
			switch (day) {
			case 12:
				System.out.println(DRUMMERS);
			case 11:
				System.out.println(PIPERS);
			case 10:
				System.out.println(LORDS);
			case 9:
				System.out.println(LADIES);
			case 8:
				System.out.println(MAIDS);
			case 7:
				System.out.println(SWANS);
			case 6:
				System.out.println(GEESE);
			case 5:
				System.out.println(RINGS);
			case 4:
				System.out.println(BIRDS);
			case 3:
				System.out.println(HENS);
			case 2:
				System.out.println(DOVES);
			case 1:
				System.out.println(PATRIDGE);
			default:
			}

		}
	}
}

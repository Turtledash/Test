package model;

public enum Card {
	As("As"), Ks("Ks"), Qs("Qs"), Js("Js"), TENs("10s"), NINEs("9s"), EIGHTs("8s"), SEVENs("7s"), SIXs("6s"), FIVEs("5s"), FOURs("4s"), THREEs("3s"), TWOs("2s"),
	Ah("Ah"), Kh("Kh"), Qh("Qh"), Jh("Jh"), TENh("10h"), NINEh("9h"), EIGHTh("8h"), SEVENh("7h"), SIXh("6h"), FIVEh("5h"), FOURh("4h"), THREEh("3h"), TWOh("2h"),
	Ac("Ac"), Kc("Kc"), Qc("Qc"), Jc("Jc"), TENc("10c"), NINEc("9c"), EIGHTc("8c"), SEVENc("7c"), SIXc("6c"), FIVEc("5c"), FOURc("4c"), THREEc("3c"), TWOc("2c"),
	Ad("Ad"), Kd("Kd"), Qd("Qd"), Jd("Jd"), TENd("10d"), NINEd("9d"), EIGHTd("8d"), SEVENd("7d"), SIXd("6d"), FIVEd("5d"), FOURd("4d"), THREEd("3d"), TWOd("2d");

	private String string;
	
	private Card(String string) {
		this.string = string;
	}
	
	public String toString() {
		return string;
	}
	
	public static Card fromString(String string) {
		for (Card c: Card.values())
			if (c.string.equals(string))
				return c;
		throw new IllegalStateException(string);
	}
}

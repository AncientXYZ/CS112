class Program07 {
	public void main(String[] args) {
		byte secondsPerMinute = 60;
		minutesPerHour = 60;
		short secondsPerHour = secondsPerMinute * minutesPerHour;
		short hoursPerDay = 24
		short secondsPerDay = secondsPerHour * hourPerDay;
		byte daysPerYear = 365;
		short secondsPerYear = secondsPerDay * daysPerYear;
		
		System.out.println("There are " + secondsPerYear + " seconds in a year.");
		float PI = 3.14159265;
		float approx = PI * 1e7;
		System.out.println("A good approximation is " + approx);
		
		float pct = 100 * (secondsPerYear - approx)/approx
		System.out.println("The percentage error is ", pct);
	}
}
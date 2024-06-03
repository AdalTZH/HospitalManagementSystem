public class Ward {
	
	private String ward;
	private String description;
	private int bedCount;
	private double bedCharge;
	
	public Ward(String ward, String description, int bedCount, double bedCharge) {
		this.ward=ward;
		this.description=description;
		this.bedCount=bedCount;
		this.bedCharge=bedCharge;
	}
	
	public String getWard() {
		return ward;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getBedCount() {
		return bedCount;
	}
	
	public double getBedCharge() {
		return bedCharge;
	}

}

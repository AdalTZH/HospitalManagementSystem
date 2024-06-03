public class Patient {
	
	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;
	
	Patient(String nric4, String name, String ward, int bed, String dateWarded, String dateDischarged, int visitorCount){
		this.nric4=nric4;
		this.name=name;
		this.ward=ward;
		this.bed=bed;
		this.dateWarded=dateWarded;
		this.dateDischarged=dateDischarged;
		this.visitorCount=visitorCount;
	}
	
	Patient(String nric4, String name, String ward, int bed, String dateWarded){
		this.nric4=nric4;
		this.name=name;
		this.ward=ward;
		this.bed=bed;
		this.dateWarded=dateWarded;
		this.dateDischarged="";
		this.visitorCount=0;
	}
	
	public String getNric4() {
		return nric4;
	}
	
	public String getName() {
		return name;
	}
	
	public String getWard() {
		return ward;
	}
	
	public int getBed() {
		return bed;
	}
	
	public String getDateWarded() {
		return dateWarded;
	}
	
	public String getDateDischarged() {
		return dateDischarged;
	}
	
	public void setDateDischarged(String a) {
		dateDischarged=a;
	}
	
	public int getVisitorCount() {
		return visitorCount;
	}
	
	public void setVisitorCount(int b) {
		visitorCount=b;
	}
	
	public void display() {
		System.out.println(String.format("\n%-18s %s %-15s","Patient Name",":",name));
		System.out.println(String.format("%-18s %s %-15s","Ward",":",ward));
		System.out.println(String.format("%-18s %s %-15d","Bed",":",bed));
		System.out.println(String.format("%-18s %s %-15s","Date warded",":",dateWarded));
		System.out.println(String.format("%-18s %s %-15s","Date discharged",":",dateDischarged));
		System.out.println(String.format("%-18s %s %-15s\n","No of visitor(s)",":",visitorCount));
	}

}

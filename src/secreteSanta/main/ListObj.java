package secreteSanta.main;

public class ListObj {
	private String person;
	private String cant1;
	private String shop_for;
	


	public ListObj(String person, String cant1){
		this.person = person;
		this.cant1 = cant1;
	}
	
	public ListObj(String person, String cant1, String shop_for){
		this.person = person;
		this.cant1 = cant1;
		this.shop_for = shop_for;
	}
	
	public ListObj(ListObj temp){
		this.person = temp.getPerson();
		this.cant1 = temp.getCant1();
		this.shop_for = temp.getShop_for();
	}
	
	public ListObj(){
		this.person = "empty";
		this.cant1 = "empty";
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getCant1() {
		return cant1;
	}

	public void setCant1(String cant1) {
		this.cant1 = cant1;
	}
	
	public String getShop_for() {
		return shop_for;
	}

	public void setShop_for(String shop_for) {
		this.shop_for = shop_for;
	}
	
	public boolean getAllow(ListObj obj){
		if(this.cant1 != obj.getPerson()){
			if(this.person != obj.getPerson()){
				setShop_for(obj.getPerson());
				return true;
			}
			return false;
		}
		else
			return false;
	}
}

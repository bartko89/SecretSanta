package secreteSanta.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import android.os.Parcel;
import android.os.Parcelable;

public class SecretSantaList implements Parcelable{
	
	private List<ListObj> person = new ArrayList<ListObj>();
	private int number_of_people;
	private int set = 0;
	
	public SecretSantaList(int number_of_people){
		this.number_of_people = number_of_people;
	}
	
	public SecretSantaList(){
		number_of_people = 0;
	}
	
	public SecretSantaList(Parcel in){
		number_of_people = in.readInt();
		set = in.readInt();

		if(set == 1){
			for (int i = 0; i < number_of_people; i++){
					person.add(new ListObj(in.readString(),in.readString(),in.readString()));
			}
		}
	}
	
	public static final Parcelable.Creator<SecretSantaList> CREATOR = new Parcelable.Creator<SecretSantaList>() {

		public SecretSantaList createFromParcel(Parcel in) {
			return new SecretSantaList(in);
		}

		public SecretSantaList[] newArray(int arg0) {
			throw new UnsupportedOperationException();
		}
	};// close Parcelable Createor definition
	
	public void setPerson( ListObj person, String name, String partner){
		person.setPerson(name);
		person.setCant1(partner);
	}
	
	public void addP(String person, String cant){
		this.set = 1;
		this.person.add(new ListObj(person, cant));
		return;
	}
	
	public ListObj getPerson(int i){
		return person.get(i);
	}
	
	public List<ListObj> getPersonList(){
		return person;
	}
	
	public void generateSecretSantaList(){ //this part is a bitch
		
		/*List<String> people = new ArrayList<String>();
		List<Integer> assign = new ArrayList<Integer>();
		
		Random v;
		Integer random_number;
		int i = 0;
		boolean listcheck = true;
		
		Iterator it = person.iterator();
		
		while(it.hasNext()){
			people.add("" + i++);	
		}
		
		i = 0;
		
		while(i < number_of_people){
			v = new Random();
			random_number = v.nextInt(number_of_people);
			
			if(!assign.contains(random_number)){
				assign.add(random_number);
				i++;
			}
		}
		
		//check value comparison
		
		while(listcheck){
			
		}
		
		Iterator it2 = person.iterator();
		*/
		/*
		while(it2.hasNext()){
			//issue random number for secret santa
			Random v = new Random();
			int random_number = v.nextInt(number_of_people);
			
			//check to see if number used
			if(people.contains(random_number))
				
			//check to see if not partner to person and assign secret santa
			while(person.get(person.lastIndexOf(it2)).getAllow(person.get(random_number))){
				v = new Random();//assign random number
				random_number = v.nextInt(number_of_people);
			}
			
			//remove person from selection
			people.remove(random_number);
		
		}
		*/
			
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
		dest.writeInt(number_of_people);
		dest.writeInt(set);
		
	
		Iterator<ListObj> it= person.iterator();
		
		if(set == 1){
			while(it.hasNext()){
					ListObj temp = new ListObj(it.next());
					
					dest.writeString(temp.getPerson());
					dest.writeString(temp.getCant1());
					dest.writeString(temp.getShop_for());
			}
		}
	

		
	}

	public int getPeople() {
		return number_of_people;
	}
}


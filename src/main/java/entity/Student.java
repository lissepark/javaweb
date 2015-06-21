package entity;

import java.util.Date;

public class Student extends AbstractModelIdName{

	private String second_name;
	private	String group;
	private Date date;
	
	public Student(){
		super();
	}

    public Student(Integer id){
        super(id);
    }
	
	public Student(String name, String second_name, String group, Date date){
		super(name);
		this.second_name = second_name;
		this.group = group;
		this.date = date;
	}

    public Student(int id,String name, String second_name, String group, Date date){
        super(id,name);
        this.second_name = second_name;
        this.group = group;
        this.date = date;
    }

    public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

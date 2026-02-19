package main.java.designPatterns;

class Subjects {
	void subjectType() {
		System.out.println("This class has 5 subjects ");
	}
}

class Science extends Subjects {
	void subjectType() {
		System.out.println("This subject is Science ");
	}
}

class Maths extends Subjects {
	void subjectType() {
		System.out.println("This subject is Maths ");
	}
}
class SocialStudies extends Subjects {
	void subjectType() {
		System.out.println("This subject is Social Studies ");
	}
}
class GK extends Subjects {
	void subjectType() {
		System.out.println("This subject is GK ");
	}
}
class Tamil extends Subjects {
	void subjectType() {
		System.out.println("This subject is Tamil ");
	}
}
class StudentSubjectClient {
	private Subjects subjects;
	public StudentSubjectClient(String type) {
		switch(type) {
		case "Science": 
			subjects=new Science();
			break;
		case "SocialStudies":
			subjects=new SocialStudies();
			break;
		case "Maths": 
			subjects=new Maths();
			break;
		case "GK":
			subjects=new GK();
			break;
        case "Tamil": 
        	subjects=new Tamil();
        	break;
        default: throw new IllegalArgumentException("Invalid subject");
			
		}
	}
	public Subjects getSubject() {
		return subjects;
	}
}
class StudentMain{
	public static void main(String[] args) {
		StudentSubjectClient subject=new StudentSubjectClient("Tamil");
		Subjects subjects=subject.getSubject();
		subjects.subjectType();
	}
}
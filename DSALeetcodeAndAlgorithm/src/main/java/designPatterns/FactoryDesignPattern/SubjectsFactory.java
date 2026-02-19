package main.java.designPatterns.FactoryDesignPattern;

abstract class Subjects {
	 abstract void subjectType();
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
interface SubjectsFactory{
	Subjects createSubjects();
}

class ScienceFactory implements SubjectsFactory {
	public Subjects createSubjects() {
		return new Science();
	}	
}

class MathsFactory implements SubjectsFactory {
	public Subjects createSubjects() {
		return new Maths();
	}
}
class SocialStudiesFactory implements SubjectsFactory {
	public Subjects createSubjects() {
		return new SocialStudies();
	}
}
class GKFactory implements SubjectsFactory {
	public Subjects createSubjects() {
		return new GK();
	}
}
class TamilFactory implements SubjectsFactory {
	public Subjects createSubjects() {
		return new Tamil();
	}
}
class SubjectsFactoryClient {
	private Subjects subjects;
	SubjectsFactoryClient(SubjectsFactory subjectsFactory){
		subjects= subjectsFactory.createSubjects();
	}
	public Subjects getSubject() {
		return subjects;
	}
}
class StudentMain{
	public static void main(String[] args) {
		SubjectsFactory subjectsFactory=new TamilFactory();
		SubjectsFactoryClient subject=new SubjectsFactoryClient(subjectsFactory);
		Subjects subjects=subject.getSubject();
		subjects.subjectType();
	}
}

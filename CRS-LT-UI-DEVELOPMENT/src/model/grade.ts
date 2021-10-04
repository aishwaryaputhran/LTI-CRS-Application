/**
 * 
 * @author G4-FullStackGroup
 * Catlog Class
 * 
 */
export class Grade {
    public  courseCode:string;
    public courseName:string;
    public grade:string;
    public studentId:number;
    
    /**
	 *Parameterized Constructor
	 * @return values
	 */
    constructor(courseCode:string, courseName:string, grade:string, studentId:number)
    {
        this.courseCode=courseCode;
        this.courseName=courseName;
        this.grade=grade;
        this.studentId=studentId;
    }
}


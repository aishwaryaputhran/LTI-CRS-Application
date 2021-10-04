/**
 * 
 * @author G4-FullStackGroup
 * RegisteredCourse Class
 * 
 */
export class RegisteredCourse {
    public  courseId:string;
    public courseName:string;
    public courseFee:number;
    public grade:string;
    public studentId:number;
    
    /**
	 *Parameterized Constructor
	 * @return values
	 */
    constructor(courseId:string, courseName:string, courseFee:number, grade:string, studentId:number)
    {
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseFee=courseFee;
        this.grade=grade;
        this.studentId=studentId;
    }
}

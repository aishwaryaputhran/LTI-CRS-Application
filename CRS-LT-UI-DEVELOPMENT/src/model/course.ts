/**
 * 
 * @author G4-FullStackGroup
 * Course Class
 * 
 */
export class Course {
    public  courseId:string;
    public courseName:string;
    public courseFee:number;
    
    // constructor(courseId:string, courseName:string)
    // {
    //     this.courseId=courseId;
    //     this.courseName=courseName;
    // }

    /**
	 *Parameterized Constructor
	 * @return values
	 */
    constructor(courseId:string, courseName:string, courseFee:number)
    {
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseFee=courseFee;
    }
}

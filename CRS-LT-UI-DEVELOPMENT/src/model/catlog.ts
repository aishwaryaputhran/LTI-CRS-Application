/**
 * 
 * @author G4-FullStackGroup
 * Catlog Class
 * 
 */
export class Catlog 
{
    public  courseId:string;
    public courseName:string;
    public courseFee:number;
        
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
/**
 * 
 * @author G4-FullStackGroup
 * Student Class
 * 
 */
export class Student 
{
    public  studentId:number;
	public  studentName:string;
	public  studentEmailId:string;
	public  studentAddress:string;
	public  branch:string;
	public  studentContactNo:number;
    public isApproved:number;

    /**
	 *Parameterized Constructor
	 * @return values
	 */
    constructor(studentId:number, studentName:string, studentEmailId:string, 
        studentAddress:string, branch:string, studentContactNo:number, isApproved:number)
    {
        this.studentId=studentId;
        this.studentName=studentName;
        this.studentEmailId=studentEmailId;
        this.studentAddress=studentAddress;
        this.branch=branch;
        this.studentContactNo=studentContactNo;
        this.isApproved=isApproved;

    }
}
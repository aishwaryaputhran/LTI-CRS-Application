/**
 * 
 * @author G4-FullStackGroup
 * Admin Class
 * 
 */
export class Admin {
    public studentID: string;
    public studentName: string;

    /**
    *Parameterized Constructor
    * @return values
    */
    constructor(studentID: string, studentName: string) {
        this.studentID = studentID;
        this.studentName = studentName;
    }
}
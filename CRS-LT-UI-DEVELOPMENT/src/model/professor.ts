/**
 * 
 * @author G4-FullStackGroup
 * Professor Class
 * 
 */
export class Professor {

	public  professorName:string;
    public userName:string;
    public password:string;
	public  department:string;
	public  professorAddress:string;
	
    /**
	 *Parameterized Constructor
	 * @return values
	 */
    constructor(professorName:string, userName:string, password:string, department:string, 
        professorAddress:string)
    {
    
        this.professorName=professorName;
        this.userName=userName;
        this.password=password;
        this.department=department;
        this.professorAddress=professorAddress;
      

    }
}
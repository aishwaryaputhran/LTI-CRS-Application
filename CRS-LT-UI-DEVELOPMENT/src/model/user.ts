/**
 * 
 * @author G4-FullStackGroup
 * User Class
 * 
 */
export class User {
    public userName: string;
    public password: String;

    /**
	 *Parameterized Constructor
	 * @return values
	 */
    constructor(userName: string, password: String) {
        this.userName = userName;
        this.password = password;

    }
}

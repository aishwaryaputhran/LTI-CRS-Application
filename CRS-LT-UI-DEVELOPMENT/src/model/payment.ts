/**
 * 
 * @author G4-FullStackGroup
 * Payment Class
 * 
 */
export class Payment {
    public mode: number;
    public amount: number;
    public cardNo: number;
    public cardName: string;
    public cvv: number;
    
    /**
	 *Parameterized Constructor
	 * @return values
	 */
    constructor(cardNo: number, cardName: string, cvv: number, amount: number, mode: number) {
    
    this.cardNo = cardNo;
    this.cardName = cardName;
    this.cvv = cvv;
    this.amount = amount;
    this.mode = mode;
    
    }
   }
import { Directive, ElementRef, Input } from '@angular/core';
 
@Directive({
 selector: '[appHighlightdirective]'
})

//Class to implement HighlighDirective
export class HighlightdirectiveDirective {
el:ElementRef
 

  @Input()
  value!: string;
constructor(el:ElementRef) 
{
 
 this.el=el;
// el.nativeElement.style.backgroundColor = 'yellow';
 
 }
//It is life cycle method which is automatically called and we can change the color using dynamic color using value attributw
 ngOnInit() {
 
 console.log("directive : ", +this.value);
 
 this.el.nativeElement.style.backgroundColor =this.value;
}
 
}
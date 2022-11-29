export function divisible_by_11( my_list ) {
	 //Insert your code here
  //console.log('my_list', my_list);
  let divisibles =0;
  for(let i=0; i<my_list.length ; i++) {
	let x=my_list[i];
	
	if(x%11==0 && x<111){
		divisibles +=1;	  
	}else if(x>=111){
	  divisibles=0;
	  i= my_list.length;
	}
  }
  return divisibles;
}
